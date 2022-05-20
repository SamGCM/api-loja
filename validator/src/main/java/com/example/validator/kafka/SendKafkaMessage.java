package com.example.validator.kafka;

import com.example.validator.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessage {
    private final KafkaTemplate<String, CompraDTO> kafkaTemplate;

    public static final String KAFKA_TOPIC = "COMPRA_TOPICO_PROCESSADA";

    public void sendMessage(CompraDTO compra) {
        kafkaTemplate.send(KAFKA_TOPIC, compra);
    }
}
