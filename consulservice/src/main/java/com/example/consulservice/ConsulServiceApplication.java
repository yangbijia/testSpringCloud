package com.example.consulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceApplication.class, args);
    }

    @GetMapping("hi")
    public String hi(String name) {
        return "hello, " + name;
    }
}

