package com.ricardocampos.constructionapp.dto.vehicle;

import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;

import java.util.UUID;

public record VehicleResponseDto(
        UUID id,
        String brand,
        VehicleType vehicleType,
        String licensePlate,
        VehicleStatus status,
        String internalCode,
        boolean active
) {
}
