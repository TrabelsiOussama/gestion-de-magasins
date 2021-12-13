package esprit.projet.emp;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface EmpRepository extends JpaRepository<Emp, Integer> {
@Query("select e from Emp e where e.name like :name")
//List<Product> findByName(String name);
public Page<Emp> EmpByName(@Param("name") String n, Pageable pageable);


}
