package com.example.aliarslan.basickafkademo.controller;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import com.example.aliarslan.basickafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProduceMessageController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/produce")
    public void sendMessage(@RequestBody List<KafkaMessage> kafkaMessageList) {
        kafkaProducerService.sendMessage(kafkaMessageList);
    }
}