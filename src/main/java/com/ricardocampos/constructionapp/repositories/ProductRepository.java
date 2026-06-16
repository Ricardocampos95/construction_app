package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
