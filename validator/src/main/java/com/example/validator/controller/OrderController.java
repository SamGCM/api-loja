package com.example.validator.controller;

import com.example.validator.dto.CompraDTO;
import com.example.validator.kafka.OrderProducer;
import com.example.validator.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    ControllerApi controllerApi;

    public OrderController(ControllerApi communicateService) {
        this.controllerApi = communicateService;
    }

    @PostMapping
    public CompraDTO send(@RequestBody CompraDTO compra) {
        return orderService.createOrder(compra);
    }
}
