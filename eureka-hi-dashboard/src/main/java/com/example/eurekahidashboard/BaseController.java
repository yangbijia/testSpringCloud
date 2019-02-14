package com.example.eurekahidashboard;

/**
 * BaseController
 *
 * @author bijiayang
 * @since 2019/01/11
 */
public class BaseController {

    public String defaultFallback(Throwable e) {
        return "default fallback : " + e;
    }
}
