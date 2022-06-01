package com.example.compra.service;

import com.example.compra.dto.CompraDTO;
import com.example.compra.model.Compra;
import com.example.compra.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    @CacheEvict(cacheNames = "Compra", allEntries = true)
    public CompraDTO save(CompraDTO compraDTO) {
        Compra compra = Compra.convert(compraDTO);
        compraRepository.save(compra);
        return compraDTO;
    }

    @Cacheable(cacheNames = "Compra", key="#root.method.name")
    public List<Compra> listAll() {
        return compraRepository.findAll();
    }

    @Cacheable(cacheNames = "Compra", key="#identifier")
    public Compra findbyId(
            String id
    ) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Identifier not found: " + id));
    }
}
