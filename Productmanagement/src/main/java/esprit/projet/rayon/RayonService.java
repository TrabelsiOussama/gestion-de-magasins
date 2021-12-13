package esprit.projet.rayon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RayonService {
	@Autowired
	private RayonRepository RayonRepository;

	public Rayon addRayon(Rayon rayon) {
		return RayonRepository.save(rayon);
	}

	public Rayon updateRayon(Integer id, Rayon newRayon) {
		if (RayonRepository.findById(id).isPresent()) {
			Rayon existingRayon = RayonRepository.findById(id).get();
			existingRayon.setId(newRayon.getId());
			existingRayon.setType(newRayon.getType());
			existingRayon.setCapacite(newRayon.getCapacite());

			return RayonRepository.save(existingRayon);
		} else
			return null;
	}

	public String deleteRayon(Integer id) {
		if (RayonRepository.findById(id).isPresent()) {
			RayonRepository.deleteById(id);
			return "Rayon supprimé";
		} else
			return "Rayon non supprimé";
	}

	public String deleteAllRayon() {
		RayonRepository.deleteAll();
		return "deleted all";
	}
}
