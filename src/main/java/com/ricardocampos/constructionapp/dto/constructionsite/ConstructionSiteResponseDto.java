package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.dto.client.ClientSummaryDto;
import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;

import java.time.LocalDate;
import java.util.UUID;

public record ConstructionSiteResponseDto(
        UUID id,
        String name,
        String location,
        LocalDate startDate,
        LocalDate endDate,
        ConstructionSiteStatus status,
        ClientSummaryDto client

) {
}
