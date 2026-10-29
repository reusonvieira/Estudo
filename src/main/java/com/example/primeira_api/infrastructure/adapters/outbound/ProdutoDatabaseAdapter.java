package com.example.primeira_api.infrastructure.adapters.outbound;

import com.example.primeira_api.domain.model.Categoria;
import com.example.primeira_api.domain.model.Produto;
import com.example.primeira_api.domain.ports.outbound.SalvarProdutoPort;
import com.example.primeira_api.infrastructure.adapters.outbound.entities.CategoriaEntity;
import com.example.primeira_api.infrastructure.adapters.outbound.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDatabaseAdapter implements SalvarProdutoPort {

    // Injetando as novas interfaces do MongoDB que você criou
    private final SpringDataProdutoRepository produtoRepository;
    private final CategoriaMongoRepository categoriaRepository;

    public ProdutoDatabaseAdapter(SpringDataProdutoRepository produtoRepository, CategoriaMongoRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        // Passamos o ID (que pode vir nulo se for uma nova categoria, e o Mongo gera automaticamente)
        CategoriaEntity entity = new CategoriaEntity(categoria.getId(), categoria.getNome());
        CategoriaEntity entitySalva = categoriaRepository.save(entity);
        return new Categoria(entitySalva.getId(), entitySalva.getNome());
    }

    @Override
    public Produto salvar(Produto produto) {
        CategoriaEntity catEntity = null;
        if (produto.getCategoria() != null) {
            catEntity = new CategoriaEntity(produto.getCategoria().getId(), produto.getCategoria().getNome());
        }

        // Passamos o ID do produto, nome, preço e a categoria tratada acima
        ProdutoEntity entity = new ProdutoEntity(produto.getId(), produto.getNome(), produto.getPreco(), catEntity);
        
        ProdutoEntity entitySalva = produtoRepository.save(entity);
        
        Categoria categoriaDoDominio = null;
        if (entitySalva.getCategoria() != null) {
            categoriaDoDominio = new Categoria(entitySalva.getCategoria().getId(), entitySalva.getCategoria().getNome());
        }

        return new Produto(entitySalva.getId(), entitySalva.getNome(), entitySalva.getPreco(), categoriaDoDominio);
    }
}
