package com.example.oxxo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class OxxoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxxoApplication.class, args);
	}

}
