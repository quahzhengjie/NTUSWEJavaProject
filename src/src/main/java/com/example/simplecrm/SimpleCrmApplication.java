package com.example.simplecrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SimpleCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrmApplication.class, args);
	}

}
