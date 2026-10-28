package com.example.primeira_api.infrastructure.adapters.outbound.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public CategoriaEntity() {}

    public CategoriaEntity(String nome) {
        this.nome = nome;
    }

    public CategoriaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
