package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekahiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekahiApplication.class, args);
	}

	@GetMapping("hi")
	public String hi(@RequestParam String str) {
		return "hello, " + str;
	}
}
