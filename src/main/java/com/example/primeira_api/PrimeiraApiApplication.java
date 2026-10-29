package com.example.primeira_api;

import com.example.primeira_api.domain.model.Categoria;
import com.example.primeira_api.domain.model.Produto;
import com.example.primeira_api.domain.ports.outbound.SalvarProdutoPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeiraApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimeiraApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner testarHexagonalComRelacionamento(SalvarProdutoPort salvarProdutoPort) {
        return args -> {
            System.out.println("\n--- TESTE ARQUITETURA HEXAGONAL COM RELACIONAMENTO (MONGODB) ---");

            // 1. Criar e salvar a Categoria usando objetos puros do domínio
            Categoria informatica = new Categoria("Informática");
            Categoria categoriaSalva = salvarProdutoPort.salvarCategoria(informatica);

            // 2. Criar e salvar o Produto vinculado à Categoria salva
            // O primeiro argumento (ID) vai como null e o MongoDB gerará a String automaticamente
            Produto notebook = new Produto(null, "Notebook Gamer Hexagonal", 5500.0, categoriaSalva);
            Produto produtoSalvo = salvarProdutoPort.salvar(notebook);

            // 3. Mostrar os dados na tela provando o desacoplamento e sucesso
            System.out.println("\n> Sucesso! Dados salvos e recuperados via Portas do Domínio no MongoDB:");
            System.out.println("ID Produto: " + produtoSalvo.getId() + 
                               " | Nome: " + produtoSalvo.getNome() + 
                               " | Preço: R$ " + produtoSalvo.getPreco() + 
                               " | Categoria: " + produtoSalvo.getCategoria().getNome() +
                               " (ID Categoria: " + produtoSalvo.getCategoria().getId() + ")");

            System.out.println("\n--- FIM DO TESTE HEXAGONAL ---");
        };
    }
}
