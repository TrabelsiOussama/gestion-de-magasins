package esprit.projet.product;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ProductRepository extends JpaRepository<Product, Integer> {
@Query("select p from Product p where p.name like :name")
//List<Product> findByName(String name);
public Page<Product> ProducttByName(@Param("name") String n, Pageable pageable);


}
