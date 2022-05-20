package com.example.cliente.repository;

import com.example.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>, JpaSpecificationExecutor<Cliente> {
    Optional<Cliente> findByTaxpayerId(String taxpayerId);
    Optional<Cliente> findById(String id);
}
