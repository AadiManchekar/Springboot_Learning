package com.aadi.kafkaproducer1.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("aadiTopic", message);

        // now this will be blocked so we need to make it async using callbacks
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                // no errors/exceptions
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset()
                        + "] to partition: " + result.getRecordMetadata().partition());
            } else {
                log.info("Unable to send message due to " + ex.getMessage());
            }
        });
    }
}
