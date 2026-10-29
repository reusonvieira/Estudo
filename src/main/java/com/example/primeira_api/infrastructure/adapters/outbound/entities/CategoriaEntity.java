package com.example.primeira_api.infrastructure.adapters.outbound.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias") // Define a coleção no MongoDB
public class CategoriaEntity {

    @Id
    private String id; // Alterado de Long para String
    private String nome;

    // Construtor padrão (Obrigatório para o Spring Data)
    public CategoriaEntity() {
    }

    // Construtor completo
    public CategoriaEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
