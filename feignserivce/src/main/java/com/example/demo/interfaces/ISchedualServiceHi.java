package com.example.demo.interfaces;

import com.example.demo.hystriximpl.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="eurekaclient",fallback = SchedualServiceHiHystrix.class)
public interface ISchedualServiceHi {

    @RequestMapping(value="hi",method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam(value="name") String name);
}
