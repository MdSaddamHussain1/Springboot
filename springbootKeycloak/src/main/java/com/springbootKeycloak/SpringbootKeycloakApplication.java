package com.springbootKeycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootKeycloakApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootKeycloakApplication.class, args);
		System.out.println("----This project configured with springboot and Keycloak.----");
	}

}
