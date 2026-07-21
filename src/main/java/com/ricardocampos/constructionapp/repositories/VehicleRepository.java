package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.Vehicle;
import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    Optional<Vehicle> findByInternalCode(String code);

    List<Vehicle> findByStatus(VehicleStatus status);

    Optional<Vehicle> findByLicensePlate(String licencePlate);

    List<Vehicle> findByVehicleType(VehicleType type);

    List<Vehicle> findByBrand(String brand);
}
