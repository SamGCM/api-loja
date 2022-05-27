package com.example.compra.dto;
import com.example.compra.model.Compra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
public class CompraDTO implements Serializable {
    private String id;
    private String id_client;
    private LocalDateTime date;
    private String id_products;
    private Float total;
    private String status;

    public static CompraDTO convert(Compra compra){
        return CompraDTO
                .builder()
                .id(compra.getId())
                .id_client(compra.getId_client())
                .date(compra.getDate())
                .id_products(compra.getId_products())
                .total(compra.getTotal())
                .status(compra.getStatus())
                .build();
    }
}
