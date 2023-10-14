package com.example.annotation.controller;

import com.example.annotation.annotation.SagRequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/check-annotation")
    public String getSag(@SagRequestParam(name = "sag") String sag) {
      return sag;
    }
}
