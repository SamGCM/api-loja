package com.example.compra.controller;

import com.example.compra.dto.CompraDTO;
import com.example.compra.gateway.ControllerApi;
import com.example.compra.kafka.SendKafkaMessage;
import com.example.compra.model.Compra;
import com.example.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class CompraController {

    @Autowired
    CompraService compraService;
    @Autowired
    ControllerApi controllerApi;

    public CompraController(ControllerApi communicateService) {
        this.controllerApi = communicateService;
    }

    @PostMapping
    public CompraDTO novaCompra(@RequestBody CompraDTO compraDTO) {
        compraDTO.setId(UUID.randomUUID().toString());
        compraDTO.setDate(LocalDateTime.now());
        compraDTO.setStatus("RECEBIDA");

        return compraService.save(compraDTO);
    }

    @GetMapping("list")
    public List<Compra> listCompras() {
        return compraService.listAll();
    }

    @GetMapping("/filter")
    public Compra findById(
            @RequestParam("id") String id
    ) {
        return compraService.findbyIdentifier(id);
    }
}
