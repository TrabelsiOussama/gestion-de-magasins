package esprit.projet.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepository;

	public Emp addEmp(Emp Emp) {
		return empRepository.save(Emp);
	}

	public Emp updateEmp(Integer id, Emp newEmp) {
		if (empRepository.findById(id).isPresent()) {
			Emp existingEmp = empRepository.findById(id).get();
			existingEmp.setName(newEmp.getName());
			existingEmp.setCin(newEmp.getCin());
			existingEmp.setNum(newEmp.getNum());

			return empRepository.save(existingEmp);
		} else
			return null;
	}

	public String deleteEmp(Integer id) {
		if (empRepository.findById(id).isPresent()) {
			empRepository.deleteById(id);
			return "Emp supprimé";
		} else
			return "Emp non supprimé";
	}

	public String deleteAllEmp() {
		empRepository.deleteAll();
		return "deleted all";
	}
}
