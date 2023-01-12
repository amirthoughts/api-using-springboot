package test.java.com.rest.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.java.com.rest.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	
	

}
