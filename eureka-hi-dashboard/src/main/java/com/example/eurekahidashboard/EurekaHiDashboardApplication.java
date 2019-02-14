package com.example.eurekahidashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 熔断器的状态
 */
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class EurekaHiDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHiDashboardApplication.class, args);
    }

}

