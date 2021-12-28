package com.example.aliarslan.basickafkademo.service;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void sendMessage(@RequestBody List<KafkaMessage> kafkaMessageList) {
        kafkaMessageList.forEach(kafkaMessage -> kafkaTemplate.send(topic, UUID.randomUUID().toString(), kafkaMessage));
    }
}
