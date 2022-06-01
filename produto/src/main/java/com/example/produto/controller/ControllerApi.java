package com.example.produto.controller;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient("produto-app")
public interface ControllerApi {

    @GetMapping("list")
    Flux<Produto> listProdutos();

    @GetMapping("filter/{id}")
    Mono<Produto> findBy(@PathVariable("id") String id);

    @PostMapping("create")
    Mono<Produto> criaProduto(@RequestBody ProdutoDTO produto);

    @DeleteMapping("delete/{id}")
    Mono<Produto> deletarProduto(@PathVariable("id") String id);
}
