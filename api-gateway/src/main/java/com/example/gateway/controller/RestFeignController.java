package com.example.gateway.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
public interface RestFeignController {

    @RequestMapping(value = "/user-feign")
    String testFeign();

}
