package com.example.compra.gateway;

import com.example.compra.model.Compra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("compra-app")
public interface ControllerApi {
    @GetMapping("list")
    List<Compra> listCompras();

    @GetMapping("filter")
    Compra findById(
            @RequestParam("id") String id
    );

}
