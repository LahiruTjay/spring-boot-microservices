package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public String helloClient() {
		String url = "http://user-service/user";
		return restTemplate.getForObject(url, String.class);
	}

}
