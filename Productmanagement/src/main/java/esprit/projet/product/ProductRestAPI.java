package esprit.projet.product;

import org.springframework.http.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/products")

public class ProductRestAPI {
	@Autowired
	private ProductService productService;
	

/*@GetMapping("/retrieve-all-products")
public List<Product> getProducts(){
List<Product> listProducts = ProductService.retrieveAllProducts();
return listProducts ;
}

@GetMapping("/retrieve-product/{id}")
public Product retrieveProduct(@PathVariable("id") int id) {

return ProductService.retrieveProduct(id);
}
	
	*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/modify-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") int id,
	    @RequestBody Product product){
	return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/remove-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int id){
	return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
}
