package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.ConstructionSiteVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ConstructionSiteVehicleRepository extends JpaRepository<ConstructionSiteVehicle, UUID> {

    List<ConstructionSiteVehicle> findByVehicleId(UUID id);

    List<ConstructionSiteVehicle> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDateTime startDate, LocalDateTime endDate);
}
