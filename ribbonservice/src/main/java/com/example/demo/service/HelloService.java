package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorService")
    public String helloService(String name){
        return restTemplate.getForObject("http://eurekaclient/hi?name="+name,String.class);
    }

    public String errorService(String name){
        return "sorroy!"+name+",there's error";
    }
}
