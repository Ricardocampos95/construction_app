package com.ricardocampos.constructionapp.entities;

import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @OneToMany(mappedBy = "vehicle",
            fetch = FetchType.LAZY)
    private List<FuelRecord> fuelRecordList;

    @OneToMany(mappedBy = "vehicle",
              fetch = FetchType.LAZY)
    private List<ConstructionSiteVehicle> constructionSiteList;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vehicle_id")
    private UUID id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType;

    @Column(name = "license_plate", unique = true)
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VehicleStatus status;

    @Column(name = "internal_code", unique = true, length = 20)
    private String internalCode;

    @Column(name = "active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;


}
