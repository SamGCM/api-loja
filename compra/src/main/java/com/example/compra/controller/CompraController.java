package com.example.compra.controller;

import com.example.compra.dto.CompraDTO;
import com.example.compra.gateway.ControllerApi;
import com.example.compra.model.Compra;
import com.example.compra.service.CompraService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CompraController {

    @Autowired
    CompraService compraService;
    @Autowired
    ControllerApi controllerApi;

    public CompraController(ControllerApi communicateService) {
        this.controllerApi = communicateService;
    }

    @CircuitBreaker(name = "create-with-error")
    @PostMapping
    public CompraDTO novaCompra(@RequestBody CompraDTO compraDTO) {
        compraDTO.setDate(LocalDateTime.now());
        compraDTO.setStatus("RECEBIDA");

        return compraService.save(compraDTO);
    }

    @CircuitBreaker(name = "list-with-error")
    @GetMapping("list")
    public List<Compra> listCompras() {
        return compraService.listAll();
    }

    @CircuitBreaker(name = "filterId-with-error")
    @GetMapping("filter")
    public Compra findById(
            @RequestParam("id") String id
    ) {
        return compraService.findbyId(id);
    }

    public String fallback(Exception ex) {
        return "From callback";
    }
}
