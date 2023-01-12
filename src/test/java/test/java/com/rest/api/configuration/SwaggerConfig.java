package test.java.com.rest.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
//    @Value("${project.version}")
//    private String version;
//    @Value("${user.swagger.baseurl}")
//    private String baseUrl;

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
    
    
    
    @Bean
    public Docket restApi() {
    	return new Docket(DocumentationType.SWAGGER_2)
    		.select()
    		.apis(RequestHandlerSelectors.basePackage("test.java.com.rest.api"))
    		.paths(PathSelectors.any())
    		.build();
		
	}

//    @Bean
//    public Docket swaggerPlugin(ServletContext servletContext) {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(regex("/*.*"))
//                .paths(not(regex("/error.*")))
//                .build()
//                .pathProvider(new RelativePathProvider(servletContext) {
//                    @Override
//                    public String getApplicationBasePath() {
//                        return baseUrl;
//                    }
//                });
//        docket.tags(new Tag("User Management", "Endpoints for user user management"));
//        docket.useDefaultResponseMessages(false);
//        return docket;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("User APIs")
//                .description("API endpoints for user")
//                .version(version)
//                .build();
//    }

}
