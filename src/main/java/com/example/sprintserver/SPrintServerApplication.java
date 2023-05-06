package com.example.sprintserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SPrintServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SPrintServerApplication.class, args);
	}

}
