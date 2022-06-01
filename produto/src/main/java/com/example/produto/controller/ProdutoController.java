package com.example.produto.controller;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.model.Produto;
import com.example.produto.service.ProdutoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    ControllerApi controllerApi;

    public ProdutoController(ControllerApi communicateService) {
        this.controllerApi = communicateService;
    }

    @CircuitBreaker(name = "list-with-error")
    @GetMapping("list")
    public Flux<Produto> listProdutos(){
        return produtoService.listAll();
    }

    @CircuitBreaker(name = "filterId-with-error")
    @GetMapping("filter")
    public Mono<Produto> findBy(@RequestParam("id") String id){
        return produtoService.findById(id);
    }

    @CircuitBreaker(name = "create-with-error")
    @PostMapping("create")
    public Mono<Produto> criaProduto(@RequestBody ProdutoDTO produto){
        return produtoService.saveProduct(produto);
    }

    @CircuitBreaker(name = "delete-with-error")
    @DeleteMapping("delete")
    public Mono<Produto> deletarProduto(@RequestParam("id") String id) {
        return produtoService.deleteById(id);
    }

    public String fallback(Exception ex) {
        return "From callback";
    }
}
