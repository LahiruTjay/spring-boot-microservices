package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RestClientController {

    @Autowired
    private RestFeignController restClientController;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @RequestMapping("/hello")
    public String helloClient() {
        String url = "http://user-service/user";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackMethod() {
        return "fall back method";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String getUserFeign() {
        return restClientController.testFeign();
    }

}
