package com.aadi.KafkaDemo1.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "aadiTopic", groupId = "myGroup")
    public void consumeMessage(String msg) {

        log.info("Consuming message from aadiTopic:: " + msg.toString());
    }
}
