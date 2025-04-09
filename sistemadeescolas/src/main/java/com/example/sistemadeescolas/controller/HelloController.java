package com.example.sistemadeescolas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String digaOla() {
        return "Olá, mundo!";
    }
}
