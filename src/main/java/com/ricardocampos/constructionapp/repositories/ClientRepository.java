package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
