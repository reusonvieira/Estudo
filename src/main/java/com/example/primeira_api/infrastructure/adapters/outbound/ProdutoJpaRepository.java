package com.example.primeira_api.infrastructure.adapters.outbound;

import com.example.primeira_api.infrastructure.adapters.outbound.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}
