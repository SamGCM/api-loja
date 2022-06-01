package com.example.validator.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private String id;
    private String client_id;
    private LocalDateTime date;
    private List<String> pr_code;
    private Long total;
    private String status;
}
