package com.pfe.elearningapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pfe.elearningapp.models")
public class ElearningAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearningAppApplication.class, args);
	}

}
