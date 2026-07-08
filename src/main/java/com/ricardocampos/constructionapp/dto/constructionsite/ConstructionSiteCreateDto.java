package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ConstructionSiteCreateDto(
        @NotBlank(message = "O nome da obra é obrigatório.")
        String name,
        @NotBlank(message = "A morada da obra é obrigatória.")
        String location,
        @NotNull(message = "É obrigatório a data de inicio.")
        @FutureOrPresent(message = "A data deve ser a atual ou uma data futura.")
        LocalDate startDate,

        @NotNull(message = "É obrigatório o estado da obra")
        ConstructionSiteStatus status,

        @NotNull(message = "É obrigatório o cliente.")
        UUID clientId
) {
}
