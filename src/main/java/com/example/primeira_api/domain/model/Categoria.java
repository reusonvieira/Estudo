package com.example.primeira_api.domain.model;

public class Categoria {
    private Long id;
    private String nome;

    // Construtor para criar uma nova categoria
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Construtor completo (usado quando o banco devolve o ID)
    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
