package com.example.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product service api documentation",
				description = "Product api",
				version = "v1",
				contact = @Contact(
						name ="Amarjeet Prajapati",
						email = "amarjeet275303@gmail.com"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Share point url Product Service Api",
				url = "example.com"

				)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
