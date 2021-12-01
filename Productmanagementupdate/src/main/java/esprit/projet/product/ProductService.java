package esprit.projet.product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
	@Autowired
	private ProductRepository ProductRepository;


	public Product addProduct(Product product) {
	return ProductRepository.save(product);
	}
	public Product updateProduct(int id, Product newProduct) {
	if (ProductRepository.findById(id).isPresent()) {
	Product existingProduct = ProductRepository.findById(id).get();
	existingProduct.setName(newProduct.getName());
	existingProduct.setDescription(newProduct.getDescription());
	existingProduct.setPrice(newProduct.getPrice());


	return ProductRepository.save(existingProduct);
	} else
	return null;
	}
	public String deleteProduct(int id) {
	if (ProductRepository.findById(id).isPresent()) {
	ProductRepository.deleteById(id);
	return "Product supprimé";
	} else
	return "Product non supprimé";
	}
}
