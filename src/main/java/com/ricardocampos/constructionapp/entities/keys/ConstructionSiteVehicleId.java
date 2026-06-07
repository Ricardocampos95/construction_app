package com.ricardocampos.constructionapp.entities.keys;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstructionSiteVehicleId implements Serializable {

    private UUID constructionSiteId;
    private UUID vehicleId;
}
