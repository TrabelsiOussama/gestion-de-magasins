package esprit.projet.product;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class ProductmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmanagementApplication.class, args);
	}

	
	@Bean
	ApplicationRunner init(ProductRepository repository) {
	    return args -> {
	        Stream.of("lait", "jus", "yaourt").forEach(name -> {
	            repository.save(new Product(name));
	        });
	        repository.findAll().forEach(System.out::println);
	    };
	}
}
