package com.example.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public String getUser() {
        return "Hello World User";
    }

    @RequestMapping("/user2")
    public String getUser2() {
        return "Hello World User22";
    }

    @RequestMapping("/user-feign")
    public String getUserFeign() {
        return "Hello World Feign works";
    }

}
