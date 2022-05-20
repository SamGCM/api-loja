package com.example.cliente.model;

import com.example.cliente.dto.ClienteDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="taxpayerId")
    private String taxpayerId;

    @Column(name="name")
    private String name;

    public static Cliente convert(ClienteDTO dto){
        return Cliente
                .builder()
                .taxpayerId(dto.getTaxpayerId())
                .name(dto.getName())
                .build();
    }

}
