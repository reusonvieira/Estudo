package com.example.primeira_api.repository;

import com.example.primeira_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // 1. Busca produtos pelo nome exato
    List<Produto> findByNome(String nome);

    // 2. Busca produtos que contenham parte do nome (igual o LIKE do SQL)
    List<Produto> findByNomeContaining(String termo);

    // 3. Busca produtos com preço maior que o valor informado
    List<Produto> findByPrecoGreaterThan(Double preco);

    // 4. Combina filtros: busca por nome E preço menor que
    List<Produto> findByNomeAndPrecoLessThan(String nome, Double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :min AND :max")
    List<Produto> buscarProdutosPorFaixaDePreco(@Param("min") Double precoMinimo, @Param("max") Double precoMaximo);
}

