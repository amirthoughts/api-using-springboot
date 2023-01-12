package test.java.com.rest.api.services;
import java.util.List;

import test.java.com.rest.api.entities.Product;

public interface ProductService {
	
	Product create(Product product);
	Product update(Product product, int productId);
	void delete(int productId);
	Product getById(int productId);
	List<Product> getAll(); 	

}
