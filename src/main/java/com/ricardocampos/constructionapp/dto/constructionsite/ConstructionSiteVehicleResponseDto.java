package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.dto.vehicle.VehicleSummaryDto;

import java.time.LocalDateTime;

public record ConstructionSiteVehicleResponseDto(
        ConstructionSiteSummary constructionSite,
        VehicleSummaryDto vehicle,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
