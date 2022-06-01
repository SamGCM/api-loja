package com.example.cliente.services;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientService {

    ClienteRepository clienteRepository;

    public Page<ClienteDTO> listAll(Pageable pageable) {
        return clienteRepository
                .findAll(pageable)
                .map(ClienteDTO::convert);
    }

    public ClienteDTO saveClient(ClienteDTO dto) {
        Cliente cliente = Cliente.convert(dto);
        return ClienteDTO.convert(clienteRepository.save(cliente));
    }

    public Cliente findByTaxpayerId(String taxpayerId) {
        Cliente cliente = clienteRepository.findByTaxpayerId(taxpayerId)
                .orElseThrow(() -> new RuntimeException());
        return cliente;
    }

    public ClienteDTO findById(String id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        return ClienteDTO.convert(cliente);
    }

}
