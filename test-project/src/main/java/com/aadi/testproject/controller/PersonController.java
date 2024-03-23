package com.aadi.testproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aadi.testproject.service.PersonService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class PersonController {
    
    private final PersonService personService;


    @GetMapping("/person")
    public String getPerson() {
        
        return "hello-world";
    }
    
}
