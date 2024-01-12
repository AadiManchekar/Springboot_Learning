package com.aadi.KafkaDemo3.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.KafkaDemo3.service.CabLocationServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/location")
@AllArgsConstructor
public class CabLocationController {

    private final CabLocationServiceImpl cabLocationServiceImpl;

    @PutMapping
    public ResponseEntity updateLocation() {

        int range = 100;
        while (range > 0) {
            System.out.println(Math.random() + " , " + Math.random());
            range--;
        }

        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
