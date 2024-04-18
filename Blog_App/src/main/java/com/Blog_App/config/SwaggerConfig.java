package com.Blog_App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
@Configuration
@SecurityScheme(
		
		name="scheme",
		type=SecuritySchemeType.HTTP,
		bearerFormat="JWT",
		scheme="bearer"
		)
@OpenAPIDefinition(
		
		info=@Info(
				 title="Blog Application Api ",
				 description="This is backend of a blog application ",
				 contact=@Contact(
						 name="Ramanjeet Singh" ,
						 email="gentalman1945@gmail.com"
						 )
				 
				),
				servers = {
						@Server(url = "/", description = "Default Server URL")
					    	}
		)

public class SwaggerConfig {


	
}
