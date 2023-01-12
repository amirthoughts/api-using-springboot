package test.java.com.rest.api.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.java.com.rest.api.entities.Product;
import test.java.com.rest.api.repositories.ProductRepository;
import test.java.com.rest.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product create(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product update(Product product, int productId) {  
		Product product1 = this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found;"));
		product1.setCategory(product.getCategory());
		product1.setFeatures(product.getCategory());
		product1.setName(product.getName());
		product1.setPrice(product.getPrice());
		
		Product save = this.productRepository.save(product1);
		
		return save;
	}

	@Override
	public void delete(int productId) {
		Product product1 = this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found;"));
	    this.productRepository.delete(product1);
	}

	@Override
	public Product getById(int productId) {
		Product product1 = this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found;"));
	    return product1;
	}

	@Override
	public List<Product> getAll() {
		List<Product> all = this.productRepository.findAll();
		
		return all;
	}
	
	

}
