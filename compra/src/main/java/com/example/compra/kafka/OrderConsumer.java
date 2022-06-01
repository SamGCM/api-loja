package com.example.compra.kafka;

import com.example.compra.dto.CompraDTO;
import com.example.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private final String KAFKA_TOPIC = "ordertopic";

    @Autowired
    CompraService compraService;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void consumer(CompraDTO compraDTO) {


        compraDTO.setDate(LocalDateTime.now());
        compraDTO.setStatus("RECEBIDA");

        compraService.save(compraDTO);
    }
}
