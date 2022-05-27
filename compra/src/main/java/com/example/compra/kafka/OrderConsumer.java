package com.example.compra.kafka;

import com.example.compra.controller.CompraController;
import com.example.compra.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String order) {
        log.info("Order: " + order);
    }
}
