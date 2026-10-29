package com.example.primeira_api.infrastructure.adapters.outbound;

import com.example.primeira_api.infrastructure.adapters.outbound.entities.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository; // Alterado o import para o MongoDB
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProdutoRepository extends MongoRepository<ProdutoEntity, String> {
    // Pronto! O MongoRepository já traz save(), findById(), deleteById() etc. configurados para String.
}
