package esprit.projet.client;

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
@RequestMapping(value = "/api/clientts")

public class ClientRestAPI {
	@Autowired
	private ClientService clientService;
	@Autowired
	ClientRepository ClientRepository;

	@GetMapping("/clinets")
	public ResponseEntity<List<Client>> getAllClient(@RequestParam(required = false) String name) {
		List<Client> clients = new ArrayList<Client>();
		ClientRepository.findAll().forEach(clients::add);
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
		Optional<Client> clientData = ClientRepository.findById(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
	}

	@PutMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Integer id, @RequestBody Client client) {
		return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
	}

	@DeleteMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteClient(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteClient() {
		return new ResponseEntity<>(clientService.deleteAllClient(), HttpStatus.OK);
	}
}
