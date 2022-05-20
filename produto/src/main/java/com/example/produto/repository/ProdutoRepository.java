package com.example.produto.repository;

import com.example.produto.model.Produto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends ReactiveMongoRepository<Produto, String> {


}
