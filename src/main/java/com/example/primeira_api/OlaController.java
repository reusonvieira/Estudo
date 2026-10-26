package com.example.primeira_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {
    @GetMapping("/boas-vindas")
    public String dizerOla() {
        return "Parabéns! Seu primeiro projeto Java com Spring Boot está rodando com sucesso! 🚀";
    }
    
}
