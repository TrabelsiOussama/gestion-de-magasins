package esprit.projet.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping(value = "/api/employes")

public class EmpRestAPI {
	@Autowired
	private EmpService empService;
	@Autowired
	EmpRepository empRepository;

	@GetMapping("/employes")
	public ResponseEntity<List<Emp>> getAllEmp(@RequestParam(required = false) String name) {
		List<Emp> employes = new ArrayList<Emp>();
		empRepository.findAll().forEach(employes::add);
		return new ResponseEntity<>(employes, HttpStatus.OK);
	}

	@GetMapping("/employes/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable("id") Integer id) {
		Optional<Emp> EmpData = empRepository.findById(id);

		if (EmpData.isPresent()) {
			return new ResponseEntity<>(EmpData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Emp> createEmp(@RequestBody Emp Emp) {
		return new ResponseEntity<>(empService.addEmp(Emp), HttpStatus.OK);
	}

	@PutMapping(value = "/employes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Emp> updateEmp(@PathVariable(value = "id") Integer id, @RequestBody Emp Emp) {
		return new ResponseEntity<>(empService.updateEmp(id, Emp), HttpStatus.OK);
	}

	@DeleteMapping(value="/employes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteEmp(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<>(empService.deleteEmp(id), HttpStatus.OK);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteEmp() {
		return new ResponseEntity<>(empService.deleteAllEmp(), HttpStatus.OK);
	}
}
