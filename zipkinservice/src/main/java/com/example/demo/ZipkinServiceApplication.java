package com.example.demo;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ZipkinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ZipkinServiceApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String home(){
		LOG.log(Level.INFO, "hi is being called");
		return  "hi i'm zipkinservice";
	}

	@RequestMapping("/serviceinfo")
	public String info(){
		LOG.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8901/info", String.class);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public Sampler defaultSamper(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
