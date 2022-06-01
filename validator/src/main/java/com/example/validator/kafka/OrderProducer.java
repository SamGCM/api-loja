package com.example.validator.kafka;

import com.example.validator.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    @Value("${order.topic}")
    private String orderTopic;

    private final KafkaTemplate<String, CompraDTO> kafkaTemplate;

    public void send(CompraDTO compra) {
        kafkaTemplate.send(orderTopic, compra);
    }
}
