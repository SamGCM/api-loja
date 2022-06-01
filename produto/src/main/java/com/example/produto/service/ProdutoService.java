package com.example.produto.service;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.model.Produto;
import com.example.produto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Mono<Produto> saveProduct(ProdutoDTO dto) {
        Produto product = Produto.convert(dto);

        return repository.save(product);
    }

    public Mono<Produto> findById (String id) {
        return repository.findById(id);
    }

    public Mono<Produto> deleteById (String id) {
        Mono<Produto> product = repository.findById(id);
        product.map(record -> repository.deleteById(id));
        return product;
    }

    public Flux<Produto> listAll () {

        return repository.findAll();
    }
}
