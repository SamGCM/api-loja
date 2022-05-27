package com.example.produto.controller;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.model.Produto;
import com.example.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/")
    public Flux<Produto> listProdutos(){
        return produtoService.listAll();
    }

    @PostMapping
    public Mono<Produto> criaProduto(@RequestBody ProdutoDTO produto){
        return produtoService.saveProduct(produto);
    }
}
