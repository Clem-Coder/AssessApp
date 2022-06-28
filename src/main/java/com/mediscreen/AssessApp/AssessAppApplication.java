package com.mediscreen.AssessApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(info = @Info(title = " AssessApp", description = "Assess patient risks microservice"))
@SpringBootApplication
@EnableFeignClients
public class AssessAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessAppApplication.class, args);
	}

}
