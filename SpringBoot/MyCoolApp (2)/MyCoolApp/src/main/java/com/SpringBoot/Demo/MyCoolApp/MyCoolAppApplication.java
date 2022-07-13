package com.SpringBoot.Demo.MyCoolApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

}
