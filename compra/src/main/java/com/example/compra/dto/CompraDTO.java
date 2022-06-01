package com.example.compra.dto;
import com.example.compra.model.Compra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
public class CompraDTO implements Serializable {
    private String id;
    private String client_id;
    private LocalDateTime date;
    private List<String> pr_code;
    private Long total;
    private String status;
}
