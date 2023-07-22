package com.aadi.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {
    @GetMapping("/greet")
    public String greet() {
        return "Hello There";
    }
}
