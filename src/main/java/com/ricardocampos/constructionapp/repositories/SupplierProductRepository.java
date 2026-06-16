package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierProductRepository extends JpaRepository<SupplierProduct, UUID> {
}
