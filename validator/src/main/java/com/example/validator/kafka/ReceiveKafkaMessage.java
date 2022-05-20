package com.example.validator.kafka;

import com.example.validator.dto.ClienteDTO;
import com.example.validator.dto.CompraDTO;
import com.example.validator.dto.ProdutoDTO;
import com.example.validator.service.ClienteService;
import com.example.validator.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {
    public static final String KAFKA_TOPIC = "COMPRA_TOPICO";
    private final SendKafkaMessage sendKafkaMessage;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "grupo-1")
    public void listenTopic(CompraDTO compraDTO) {

        ClienteDTO clienteDTO = ClienteService.getClient(compraDTO.getClient_id());
        if (clienteDTO == null && clienteDTO.getId() != null) {
            throw new RuntimeException("Client not found.");
        }

        Float valorTotal = 0F;
        for (String produto : compraDTO.getPr_code()) {
            ProdutoDTO produtoDTO = ProdutoService.getProduto(produto);
            if (produtoDTO == null) {
                throw new RuntimeException("Produto invalido.");
            }
            valorTotal += produtoDTO.getPrice();
        }
        compraDTO.setTotal(valorTotal);
        compraDTO.setStatus("PROCESSADA");

        System.out.println("Compra processada: " + compraDTO.getId() + " " + compraDTO.getTotal());
        sendKafkaMessage.sendMessage(compraDTO);

    }
}
