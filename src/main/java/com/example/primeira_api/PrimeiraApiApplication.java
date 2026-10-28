package com.example.primeira_api;

import com.example.primeira_api.model.Categoria;
import com.example.primeira_api.model.Produto;
import com.example.primeira_api.repository.CategoriaRepository;
import com.example.primeira_api.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class PrimeiraApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimeiraApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner testarJPA(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        return args -> {
            System.out.println("\n--- ENTRANDO NO CODIGO DE TESTE DO JPA (COM RELACIONAMENTO) ---");

            // 1. Criar e salvar as Categorias primeiro (O JPA precisa que o pai exista no banco)
            Categoria eletronicos = categoriaRepository.save(new Categoria("Eletrônicos"));
            Categoria informatica = categoriaRepository.save(new Categoria("Informática"));

            // 2. Criar e salvar os Produtos já vinculados às suas Categorias
            produtoRepository.save(new Produto("Notebook", 3500.0, informatica));
            produtoRepository.save(new Produto("Mouse Gamer", 150.0, informatica));
            produtoRepository.save(new Produto("Teclado Mecânico", 250.0, informatica));
            produtoRepository.save(new Produto("Monitor 4K", 2100.0, eletronicos));

            // 3. Buscar todos os produtos e mostrar a categoria de cada um
            System.out.println("\n> Listando todos os produtos e suas respectivas categorias:");
            List<Produto> todos = produtoRepository.findAll();
            todos.forEach(p -> System.out.println(
                "Produto: " + p.getNome() + 
                " | Preço: R$ " + p.getPreco() + 
                " | Categoria: " + p.getCategoria().getNome()
            ));

            System.out.println("\n--- FIM DO TESTE DO JPA ---");
        };
    }
}
