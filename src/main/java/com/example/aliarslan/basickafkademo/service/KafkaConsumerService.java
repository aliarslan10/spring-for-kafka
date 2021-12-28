package com.example.aliarslan.basickafkademo.service;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
    public void listen(@Payload KafkaMessage kafkaMessage) {
        log.info("Message received. MessageID : {} Message: {} Date : {}",
                kafkaMessage.getId(), kafkaMessage.getMessage(), kafkaMessage.getMessageDate());
    }
}
