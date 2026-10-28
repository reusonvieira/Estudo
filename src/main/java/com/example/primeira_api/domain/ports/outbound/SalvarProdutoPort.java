package com.example.primeira_api.domain.ports.outbound;

import com.example.primeira_api.domain.model.Categoria;
import com.example.primeira_api.domain.model.Produto;

public interface SalvarProdutoPort {
    Produto salvar(Produto produto);
    Categoria salvarCategoria(Categoria categoria);
}
