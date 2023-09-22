package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/ok")
	public String okGet(@RequestParam(name = "data", required = false) String data) {
		if (data != null) {
			return "Response to GET request: " + data;
		} else {
			return "Response to GET request: OK!";
		}
	}

	@PostMapping("/ok")
	public String okPost(@RequestBody String requestBody) {
		return "Response to POST request: " + requestBody;
	}
}
