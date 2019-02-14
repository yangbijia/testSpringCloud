package com.example.eurekahidashboard;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

/**
 * MyHystrixCommand
 *
 * @author bijiayang
 * @since 2019/01/11
 */
public class MyHystrixCommand extends HystrixCommand<String> {


    public MyHystrixCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("query")));
    }

    @Override
    protected String run() throws Exception {

        return null;
    }
}
