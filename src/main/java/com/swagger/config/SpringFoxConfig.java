package com.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	        "Employee Management Rest API Documentation",
	        "Api Documentation",
	        "1.0",
	        "",
	        new springfox.documentation.service.Contact("sabin", "", "gsabin180@gmail.com"),
	        "",
	        "",
	        Collections.emptyList()
	    );
	}
}
