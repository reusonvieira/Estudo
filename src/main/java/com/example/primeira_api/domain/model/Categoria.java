package com.example.primeira_api.domain.model;

public class Categoria {
    private String id; // Alterado de Long para String
    private String nome;

    // Construtor para criar uma nova categoria (o ID começa nulo e o Mongo gera depois)
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Construtor completo (usado quando o banco devolve o ID como String)
    public Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters atualizados
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
