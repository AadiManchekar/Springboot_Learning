package com.aadi.KafkaDemo3.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CabLocationServiceImpl implements CabLocationService {

    private final org.springframework.kafka.core.KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send("cab-location", location);
        return true;
    }
}
