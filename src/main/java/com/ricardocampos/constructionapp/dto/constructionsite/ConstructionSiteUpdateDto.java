package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record ConstructionSiteUpdateDto(
        @Size(min= 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String name,

        String location,

        @FutureOrPresent(message = "A data deve ser a atual ou uma data futura.")
        LocalDate startDate,

        ConstructionSiteStatus status,

        UUID clientId,

        Boolean active,
        @PastOrPresent(message = "A data deve ser presente ou passada.")
        LocalDate endDate


) {
}
