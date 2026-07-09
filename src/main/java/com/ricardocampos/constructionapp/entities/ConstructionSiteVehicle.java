package com.ricardocampos.constructionapp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "construction_site_vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionSiteVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "construction_site_vehicle_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;


}
