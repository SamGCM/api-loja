package com.example.compra.kafka;

import com.example.compra.controller.CompraController;
import com.example.compra.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {
    private final String KAFKA_TOPIC = "COMPRA_TOPICO_PROCESSADA";

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic3(CompraDTO compraDTO) {
        CompraController.compras.put(compraDTO.getIdentificadorCliente(), compraDTO);
    }
}
