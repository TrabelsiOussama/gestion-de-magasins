package esprit.projet.client;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ClientRepository extends JpaRepository<Client, Integer> {
@Query("select c from Client c where c.name like :name")
//List<Client> findByName(String name);
public Page<Client> ClientByName(@Param("name") String n, Pageable pageable);


}
