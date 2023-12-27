package com.aadi.KafkaDemo1.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.aadi.KafkaDemo1.payload.Student;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "aadiTopic", groupId = "myGroup")
    public void consumeMessage(String msg) {

        log.info("Consuming message from aadiTopic:: " + msg.toString());
    }

    @KafkaListener(topics = "aadiTopicJson", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {

        log.info("Consuming message from aadiTopicJson:: " + student.toString());
    }
}
