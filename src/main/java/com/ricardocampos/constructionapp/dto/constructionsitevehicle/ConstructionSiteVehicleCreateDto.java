package com.ricardocampos.constructionapp.dto.constructionsitevehicle;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConstructionSiteVehicleCreateDto(
        @NotNull(message = "A obra é obrigatória.")
        UUID constructionSiteId,
        @NotNull(message = "O veiculo é obrigatório.")
        UUID vehicleId,
        @NotNull(message = "A data de início é obrigatória.")
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
