package test.java.com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "test.java.com.rest.api")
public class ApiUsingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsingSpringbootApplication.class, args);
	}

}
