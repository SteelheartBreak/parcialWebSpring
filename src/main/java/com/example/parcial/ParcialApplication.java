package com.example.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.parcial.modelo"})
public class ParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialApplication.class, args);
	}

}
