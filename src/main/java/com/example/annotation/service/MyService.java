package com.example.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public boolean isUserAuthorize(String sag) {
        return sag.equals("A00000123");
    }
}
