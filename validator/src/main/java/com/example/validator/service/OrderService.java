package com.example.validator.service;

import com.example.validator.dto.ClienteDTO;
import com.example.validator.dto.CompraDTO;
import com.example.validator.dto.ProdutoDTO;
import com.example.validator.kafka.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderProducer orderProducer;

    public CompraDTO createOrder(CompraDTO compraDTO){
        compraDTO.setId(UUID.randomUUID().toString());
        compraDTO.setDate(LocalDateTime.now());
        compraDTO.setStatus("VALIDANDO");
        compraDTO.setTotal(
                calcTotal(compraDTO.getPr_code())
        );

        compraDTO.setClient_id(
                verifyCliente(compraDTO.getClient_id())
                        .getTaxpayerId()
        );
        orderProducer.send(compraDTO);

        return compraDTO;
    }

    private Long calcTotal(List<String> products){
        Long total = 0L;

        for(String id : products){
            ProdutoDTO produto = ProdutoService.getProduto(id);
            total = total + produto.getPrice();
        }

        return total;
    }

    private ClienteDTO verifyCliente(String id){
        ClienteDTO cliente =  ClienteService.getClient(id);
        return cliente;
    }
}
