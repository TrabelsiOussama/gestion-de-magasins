package esprit.projet.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	private ClientRepository ClientRepository;

	public Client addClient(Client client) {
		return ClientRepository.save(client);
	}

	public Client updateClient(Integer id, Client newClient) {
		if (ClientRepository.findById(id).isPresent()) {
			Client existingClient = ClientRepository.findById(id).get();
			existingClient.setName(newClient.getName());


			return ClientRepository.save(existingClient);
		} else
			return null;
	}

	public String deleteClient(Integer id) {
		if (ClientRepository.findById(id).isPresent()) {
			ClientRepository.deleteById(id);
			return "Client supprimé";
		} else
			return "Client non supprimé";
	}

	public String deleteAllClient() {
		ClientRepository.deleteAll();
		return "deleted all";
	}
}
