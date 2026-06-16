package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
