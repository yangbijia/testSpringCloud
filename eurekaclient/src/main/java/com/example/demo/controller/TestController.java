package com.example.demo.controller;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration; // 服务注册

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        ServiceInstance instance = serviceInstance();
        return "hi " + name + " ,i am from port:" + port
                + "<br>, host:" + (instance == null ? "--" : instance.getHost()) + ", service_id:" + (instance == null ? "--" : instance.getServiceId());
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 8763)
                    return itm;
            }
        }
        return null;
    }

}
