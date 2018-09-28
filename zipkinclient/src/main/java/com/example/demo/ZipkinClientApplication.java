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
public class ZipkinClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ZipkinClientApplication.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace zipkinclient");
		return  restTemplate.getForObject("http://localhost:8902/hi", String.class);
	}

	@RequestMapping("/info")
	public  String info(){
		LOG.log(Level.INFO, "calling trace zipkinclient");
		return "I'am zipkinclient";
	}

	@Bean
	public Sampler defaultSamper(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
