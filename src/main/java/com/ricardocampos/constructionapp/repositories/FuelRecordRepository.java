package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.FuelRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelRecordRepository extends JpaRepository<FuelRecord, UUID> {
}
