package com.example.produto.dto;


import com.example.produto.model.Produto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "produto")
public class ProdutoDTO {

    private String id;
    private String code;
    private Long price;
    private int units;

    public static ProdutoDTO convert(Produto produto){
        return ProdutoDTO
                .builder()
                .code(produto.getCode())
                .price(produto.getPrice())
                .units(produto.getUnits())
                .id(produto.getId())
                .build();
    }

}
