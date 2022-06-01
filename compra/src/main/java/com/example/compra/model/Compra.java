package com.example.compra.model;

import com.example.compra.dto.CompraDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Compra implements Serializable {
    @Id
    private String id;
    private String id_client;
    private LocalDateTime date;
    private String id_products;
    private Long total;
    private String status;

    public static Compra convert(CompraDTO dto){
        return Compra
                .builder()
                .id(dto.getId())
                .id_client(dto.getClient_id())
                .date(dto.getDate())
                .id_products(dto.getPr_code().toString())
                .total(dto.getTotal())
                .status(dto.getStatus())
                .build();
    }


}
