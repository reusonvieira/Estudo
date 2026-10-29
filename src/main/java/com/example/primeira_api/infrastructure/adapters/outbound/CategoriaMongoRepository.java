package com.example.primeira_api.infrastructure.adapters.outbound;

import com.example.primeira_api.infrastructure.adapters.outbound.entities.CategoriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository; // Import do MongoDB

public interface CategoriaMongoRepository extends MongoRepository<CategoriaEntity, String> {
    // Agora o repositório está pronto para gerenciar as categorias no MongoDB usando IDs do tipo String.
}
