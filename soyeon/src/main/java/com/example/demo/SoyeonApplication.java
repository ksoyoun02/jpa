package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoyeonApplication{

	public static void main(String[] args) {
		System.out.println("===================start====================");
		SpringApplication.run(SoyeonApplication.class, args);
	}
	
}
