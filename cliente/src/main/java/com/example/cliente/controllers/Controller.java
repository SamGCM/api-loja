package com.example.cliente.controllers;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.model.Cliente;
import com.example.cliente.services.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class Controller {

    private final ClientService clientService;

    @GetMapping("/")
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
