package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.ConstructionSiteVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ConstructionSiteVehicleRepository extends JpaRepository<ConstructionSiteVehicle, UUID> {
}
