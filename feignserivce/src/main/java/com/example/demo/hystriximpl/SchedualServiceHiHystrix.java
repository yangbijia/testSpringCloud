package com.example.demo.hystriximpl;

import com.example.demo.interfaces.ISchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystrix implements ISchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,there's error";
    }
}
