package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;

import java.time.LocalDate;
import java.util.UUID;

public record ConstructionSiteCreateDto(
        String name,
        String location,
        LocalDate startDate,
        UUID clientId
) {
}
