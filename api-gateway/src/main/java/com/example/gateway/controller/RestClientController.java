package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class RestClientController {

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

}
