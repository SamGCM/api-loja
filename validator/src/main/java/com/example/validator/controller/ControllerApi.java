package com.example.validator.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("validator-app")
public interface ControllerApi {
    @RequestMapping(method = RequestMethod.POST)
    void send(@RequestBody String order);
}
