package com.example.demo.controller;

import com.example.demo.interfaces.ISchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ISchedualServiceHi iSchedualServiceHi;

    @GetMapping(value="hi")
    public String sayHi(@RequestParam String name){
        return  iSchedualServiceHi.sayHiFromClientOne(name);
    }
}
