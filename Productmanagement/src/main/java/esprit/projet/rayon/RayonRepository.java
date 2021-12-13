package esprit.projet.rayon;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface RayonRepository extends JpaRepository<Rayon, Integer> {
@Query("select r from Rayon r where r.type like :type")
//List<Rayon> findByName(String name);
public Page<Rayon> RayonByName(@Param("type") String n, Pageable pageable);


}
