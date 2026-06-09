package com.ricardocampos.constructionapp.dto.vehicle;

import java.util.UUID;

public record VehicleSummaryDto(
        UUID id,
        String licensePlate,
        String internalCode
) {
}
