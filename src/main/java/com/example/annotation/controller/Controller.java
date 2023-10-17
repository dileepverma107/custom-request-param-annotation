package com.example.annotation.controller;

import com.example.annotation.annotation.SagPathVariable;
import com.example.annotation.annotation.SagRequestParam;
import com.example.annotation.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final MyService myService;

    public Controller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/check-annotation")
    //@PreAuthorize("@myService.isUserAuthorize(#sagCode)")
    public String getSag(@SagRequestParam(name = "sag") String sagCode,
                         @RequestParam(name = "isMember", defaultValue = "false") Boolean isMember) {
      return sagCode;
    }

    @GetMapping("/example/{customValue}")
    public String exampleController(@SagPathVariable String customValue) {
        return "Custom Path Variable: " + customValue;
    }
}
