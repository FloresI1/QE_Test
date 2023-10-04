package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	private String storedData = null;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/ok")
	public String okGet() {
		if (storedData == null) {
			return "Response to GET request: No data available.";
		} else {
			return "Response to GET request: " + storedData;
		}
	}

	@PostMapping("/ok")
	public String okPost(@RequestBody String requestBody) {
		storedData = requestBody;
		return "Response to POST request: Data saved.";
	}
}
