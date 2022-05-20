package com.example.compra.controller;

import com.example.compra.dto.CompraDTO;
import com.example.compra.kafka.SendKafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    public static Map<String, CompraDTO> compras = new HashMap<>();
    private final SendKafkaMessage sendKafkaMessage;

    @PostMapping
    public CompraDTO novaCompra(@RequestBody CompraDTO compraDTO) {
        compraDTO.setIdentificador(UUID.randomUUID().toString());
        compraDTO.setHoraCompra(LocalDateTime.now());
        compraDTO.setStatus("RECEBIDA");

        compras.put(compraDTO.getIdentificador(), compraDTO);
        sendKafkaMessage.sendMessage(compraDTO);

        return compraDTO;
    }

    @GetMapping
    public List<CompraDTO> listCompras() {
        return new ArrayList<>(compras.values());
    }

}
