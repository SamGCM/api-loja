package com.example.compra.dto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraDTO implements Serializable {
    private String id;
    private String client_id;
    private LocalDateTime date;
    private List<String> pr_code;
    private Long total;
    private String status;
}
