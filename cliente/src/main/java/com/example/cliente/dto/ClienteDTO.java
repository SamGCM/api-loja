package com.example.cliente.dto;

import com.example.cliente.model.Cliente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private String taxpayerId;
    private String name;

    public static ClienteDTO convert(Cliente cliente){
        return ClienteDTO
                .builder()
                .taxpayerId(cliente.getTaxpayerId())
                .name(cliente.getName())
                .build();
    }
}
