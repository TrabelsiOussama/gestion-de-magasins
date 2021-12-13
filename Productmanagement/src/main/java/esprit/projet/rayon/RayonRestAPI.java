package esprit.projet.rayon;

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
@RequestMapping(value = "/api/rayons")

public class RayonRestAPI {
	@Autowired
	private RayonService rayonService;
	@Autowired
	RayonRepository rayonRepository;

	@GetMapping("/rayons")
	public ResponseEntity<List<Rayon>> getAllRayon(@RequestParam(required = false) String name) {
		List<Rayon> rayons = new ArrayList<Rayon>();
		rayonRepository.findAll().forEach(rayons::add);
		return new ResponseEntity<>(rayons, HttpStatus.OK);
	}

	@GetMapping("/rayons/{id}")
	public ResponseEntity<Rayon> getRayonById(@PathVariable("id") Integer id) {
		Optional<Rayon> RayonData = rayonRepository.findById(id);

		if (RayonData.isPresent()) {
			return new ResponseEntity<>(RayonData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/rayons")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Rayon> createRayon(@RequestBody Rayon rayon) {
		return new ResponseEntity<>(rayonService.addRayon(rayon), HttpStatus.OK);
	}

	@PutMapping(value = "/rayons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Rayon> updateRayon(@PathVariable(value = "id") Integer id, @RequestBody Rayon rayon) {
		return new ResponseEntity<>(rayonService.updateRayon(id, rayon), HttpStatus.OK);
	}

	@DeleteMapping(value = "/rayons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteRayon(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<>(rayonService.deleteRayon(id), HttpStatus.OK);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteRayon() {
		return new ResponseEntity<>(rayonService.deleteAllRayon(), HttpStatus.OK);
	}
}
