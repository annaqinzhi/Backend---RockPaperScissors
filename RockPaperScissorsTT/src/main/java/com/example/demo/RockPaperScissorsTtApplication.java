package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller", "service"})
public class RockPaperScissorsTtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsTtApplication.class, args);
	}

}
