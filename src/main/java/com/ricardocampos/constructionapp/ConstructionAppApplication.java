package com.ricardocampos.constructionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ConstructionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionAppApplication.class, args);
	}

}
