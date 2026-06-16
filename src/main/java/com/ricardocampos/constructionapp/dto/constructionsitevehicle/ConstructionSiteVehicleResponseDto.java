package com.ricardocampos.constructionapp.dto.constructionsitevehicle;

import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteSummary;
import com.ricardocampos.constructionapp.dto.vehicle.VehicleSummaryDto;

import java.time.LocalDateTime;

public record ConstructionSiteVehicleResponseDto(
        ConstructionSiteSummary constructionSite,
        VehicleSummaryDto vehicle,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
