package com.example.validator.service;

import com.example.validator.dto.ClienteDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ClienteService {
    public static ClienteDTO getClient(String id) {
        WebClient webClient = WebClient.create("http://localhost:8083");

        return webClient
                .get()
                .uri("/filterId?id={id}", id)
                .retrieve()
                .bodyToMono(ClienteDTO.class)
                .block();
    }
}
