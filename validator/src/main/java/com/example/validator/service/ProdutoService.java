package com.example.validator.service;

import com.example.validator.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ProdutoService {
    public static ProdutoDTO getProduto(String code) {
        WebClient webClient = WebClient.create("http://localhost:8085");

        return webClient
                .get()
                .uri("/produto/busca?code={id}", code)
                .retrieve()
                .bodyToMono(ProdutoDTO.class)
                .block();
    }
}
