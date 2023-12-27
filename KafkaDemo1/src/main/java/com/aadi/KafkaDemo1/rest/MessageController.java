package com.aadi.KafkaDemo1.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aadi.KafkaDemo1.payload.Student;
import com.aadi.KafkaDemo1.producer.KafkaJsonProducer;
import com.aadi.KafkaDemo1.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;


    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Queued Successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Message Queued Successfully as Json");
    }
}
