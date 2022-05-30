package com.example.cliente.controllers;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.gateway.ControllerApi;
import com.example.cliente.model.Cliente;
import com.example.cliente.services.ClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    @Autowired
    ClientService clientService;
    @Autowired
    ControllerApi controllerApi;

    public Controller(ControllerApi communicateService) {
        this.controllerApi = communicateService;
    }

    @GetMapping("list")
    public Page<ClienteDTO> listAll(Pageable pageable) {
        return clientService.listAll(pageable);
    }

    @RequestMapping("/filter")
    public Cliente findClientTaxpayerId(
            @RequestParam("taxpayerId") String taxpayerId
            ) {
        return clientService.findByTaxpayerId(taxpayerId);
    }

    @RequestMapping("/filterId")
    public ClienteDTO findClientId(
            @RequestParam("id") String id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClienteDTO createClient(@RequestBody ClienteDTO cliente){
        return clientService.saveClient(cliente);
    }

}
