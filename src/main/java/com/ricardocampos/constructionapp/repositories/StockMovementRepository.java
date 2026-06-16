package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovement, UUID> {
}
