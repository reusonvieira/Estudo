package com.example.primeira_api.infrastructure.adapters.outbound;

import com.example.primeira_api.domain.model.Categoria;
import com.example.primeira_api.domain.model.Produto;
import com.example.primeira_api.domain.ports.outbound.SalvarProdutoPort;
import com.example.primeira_api.infrastructure.adapters.outbound.entities.CategoriaEntity;
import com.example.primeira_api.infrastructure.adapters.outbound.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDatabaseAdapter implements SalvarProdutoPort {

    private final ProdutoJpaRepository jpaRepository;
    private final CategoriaJpaRepository categoriaJpaRepository;

    public ProdutoDatabaseAdapter(ProdutoJpaRepository jpaRepository, CategoriaJpaRepository categoriaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.categoriaJpaRepository = categoriaJpaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        CategoriaEntity entity = new CategoriaEntity(categoria.getNome());
        CategoriaEntity entitySalva = categoriaJpaRepository.save(entity);
        return new Categoria(entitySalva.getId(), entitySalva.getNome());
    }

    @Override
    public Produto salvar(Produto produto) {
        CategoriaEntity catEntity = new CategoriaEntity(produto.getCategoria().getId(), produto.getCategoria().getNome());
        ProdutoEntity entity = new ProdutoEntity(produto.getNome(), produto.getPreco(), catEntity);
        
        ProdutoEntity entitySalva = jpaRepository.save(entity);
        
        Categoria categoriaDoDominio = new Categoria(entitySalva.getCategoria().getId(), entitySalva.getCategoria().getNome());
        return new Produto(entitySalva.getId(), entitySalva.getNome(), entitySalva.getPreco(), categoriaDoDominio);
    }
}
