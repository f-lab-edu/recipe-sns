package com.recipesns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RecipeSnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSnsApplication.class, args);
	}

}
