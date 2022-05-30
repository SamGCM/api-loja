package com.example.cliente.gateway;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@FeignClient("cliente-app")
public interface ControllerApi {

    @GetMapping("list")
    Page<ClienteDTO> listAll(Pageable pageable);

    @PostMapping("/")
    ClienteDTO createClient(
            @RequestBody ClienteDTO cliente
    );

    @RequestMapping("/filter")
    Cliente findClientTaxpayerId(
        @RequestParam("taxpayerId") String taxpayerId
    );

    @RequestMapping("/filterId")
    ClienteDTO findClientId(
        @RequestParam("id") String id
    );

}

