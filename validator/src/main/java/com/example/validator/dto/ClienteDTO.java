package com.example.validator.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {
    private String taxpayerId;
    private String name;
}
