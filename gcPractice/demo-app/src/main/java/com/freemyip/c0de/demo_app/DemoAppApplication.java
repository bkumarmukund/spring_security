package com.freemyip.c0de.demo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoAppApplication {


	@GetMapping("/home")
	public String home() {
		return "welcome anynymous user";
	}
	@GetMapping("/user/home")
	public String homeOfUser() {
		return "welcome logged in user";
	}
	@GetMapping("/admin/home")
	public String homeOfAdmin() {
		return "welcome admin";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

}

