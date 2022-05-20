package com.example.produto.model;

import com.example.produto.dto.ProdutoDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Produto {
    @Id
    private String id;
    private String code;
    private Long price;
    private Integer units;

    public static Produto convert(ProdutoDTO dto) {
        return Produto
                .builder()
                .code(dto.getCode())
                .price(dto.getPrice())
                .units(dto.getUnits())
                .build();
    }
}
