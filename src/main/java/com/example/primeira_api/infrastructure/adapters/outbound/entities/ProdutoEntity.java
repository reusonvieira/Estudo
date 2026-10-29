package com.example.primeira_api.infrastructure.adapters.outbound.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos") // Define a coleção no MongoDB
public class ProdutoEntity {
    
    @Id
    private String id; // Alterado de Long para String
    private String nome;
    private Double preco;
    
    // Sem @ManyToOne ou @JoinColumn. O objeto fica direto aqui (documento embarcado).
    private CategoriaEntity categoria; 

    // Construtor padrão (Obrigatório para o Spring Data)
    public ProdutoEntity() {
    }

    // Construtor completo
    public ProdutoEntity(String id, String nome, Double preco, CategoriaEntity categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public CategoriaEntity getCategoria() { return categoria; }
    public void setCategoria(CategoriaEntity categoria) { this.categoria = categoria; }
}
