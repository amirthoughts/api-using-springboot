package test.java.com.rest.api.controller;


import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import test.java.com.rest.api.entities.Product;
import test.java.com.rest.api.services.ProductService;

@XmlRootElement
@RestController
@RequestMapping("/products")
@Api(value = "/products", tags = "Products Management")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
//	@GetMapping("/")
//	public Product test() {
//		
//		Product product = new Product();
//		
//		product.setName("Realme 5 Pro");
//		product.setId(1);
//		product.setCategory("Mobile");
//		product.setPrice(17000.00);
//		product.setFeatures("RAM - 8GB, Storage - 128GB");
//		
//		return product;
//	}
	
	
	
	//create
	@PostMapping(value = "/createProduct", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Create Product", notes = "Create new products", tags = { "Products Management" })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created - Product created successfully"),
			@ApiResponse(code = 400, message = "Bad Request - Please check your inputs"),
			@ApiResponse(code = 500, message = "Internal server error - Something went wrong in the backend")
	})
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product1 =  this.productService.create(product);
		return new ResponseEntity<>(product1, HttpStatus.CREATED);
	}
	
	//update
	
	@PutMapping(value = "/{productId}",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Update Product", notes = "Update the product", tags = { "Products Management" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Product updated successfully"),
			@ApiResponse(code = 400, message = "Bad Request - Please check your inputs"),
			@ApiResponse(code = 404, message = "Not Found - Please check the endpoint or product id"),
			@ApiResponse(code = 500, message = "Internal server error - Something went wrong in the backend")
	})
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int productId){
		Product product1 =  this.productService.update(product, productId);
		return new ResponseEntity<>(product1, HttpStatus.OK);
	}
	
	//delete
	
	@DeleteMapping(value = "/{productId}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Delete Product", notes = "Delete the product", tags = { "Products Management" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Product deleted successfully"),
			@ApiResponse(code = 400, message = "Bad Request - Please check your inputs"),
			@ApiResponse(code = 404, message = "Not Found - Please check the endpoint or product id"),
			@ApiResponse(code = 500, message = "Internal server error - Something went wrong in the backend")
	})
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable int productId){
		this.productService.delete(productId);
		Map<String, String> message = Map.of("message", "Product deleted successfully");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
	//get single product
	
	@GetMapping(value = "/{productId}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Get Single Product", notes = "Get single product", tags = { "Products Management" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Product fetched successfully"),
			@ApiResponse(code = 400, message = "Bad Request - Please check your inputs"),
			@ApiResponse(code = 404, message = "Not Found - Please check the endpoint or product id"),
			@ApiResponse(code = 500, message = "Internal server error - Something went wrong in the backend")
	})
	public ResponseEntity<Product> getproduct(@PathVariable int productId){
		Product product = this.productService.getById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	//get all products
	
		@GetMapping(value = "",
				produces = {MediaType.APPLICATION_JSON_VALUE})
		@ApiOperation(value = "Get All Products", notes = "Get all products", tags = { "Products Management" })
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK - Product fetched successfully"),
				@ApiResponse(code = 400, message = "Bad Request - Please check your inputs"),
				@ApiResponse(code = 500, message = "Internal server error - Something went wrong in the backend")
		})
		public ResponseEntity<List<Product>> getAll(){
			List<Product> all = this.productService.getAll();
			return new ResponseEntity<>(all, HttpStatus.OK);
		}
	
	
	
	

}
