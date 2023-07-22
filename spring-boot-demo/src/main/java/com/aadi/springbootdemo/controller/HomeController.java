package com.aadi.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.springbootdemo.model.User;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @GetMapping("/user")
    public User getDummyUser() {
        User user = new User();
        user.setId("1");
        user.setName("dummy");
        user.setEmailId("dummy@gmail.com");

        return user;
    }

    @GetMapping("/{id1}/{id2}")
    public String pathVariable(@PathVariable String id1, @PathVariable String id2) {
        return id1 + " , " + id2;
    }

    // http://localhost:8080/requestParam?name=Aadi&email=xyz@gmail.com
    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
            @RequestParam(required = false, defaultValue = "") String email) {
        return name + " , " + email;
    }

}
