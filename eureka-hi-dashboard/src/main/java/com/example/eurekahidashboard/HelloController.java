package com.example.eurekahidashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * HelloController
 *
 * @author bijiayang
 * @since 2019/01/11
 */
@RestController
public class HelloController extends BaseController {

    @Value("${server.port}")
    String port;

    @RequestMapping("hi")
    @HystrixCommand(defaultFallback = "defaultFallback")
    public String sayHello(String name) {
        return "hello," + name + "-" + port;
    }

    @RequestMapping("hiMore")
    @HystrixCommand(defaultFallback = "defaultFallback" ,fallbackMethod = "fallback")
    public String sayHelloMore(String name) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello, ......... ," + name + "-" + port;
    }

    public String fallback(String s, Throwable e) {
        return s + "," + e;
    }
}
