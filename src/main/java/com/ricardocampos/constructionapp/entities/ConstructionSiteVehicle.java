package com.ricardocampos.constructionapp.entities;


import com.ricardocampos.constructionapp.entities.keys.ConstructionSiteVehicleId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "construction_site_vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionSiteVehicle {

    @EmbeddedId
    private ConstructionSiteVehicleId id;

    @ManyToOne
    @MapsId("constructionSiteId")
    @JoinColumn(name = "construction_site_id")
    private ConstructionSite constructionSite;

    @ManyToOne
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;


}
