package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.constructionsite.*;
import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.entities.ConstructionSiteVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {ClientMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConstructionSiteMapper {

    ConstructionSite toEntity(ConstructionSiteCreateDto dto);
    ConstructionSiteResponseDto toDto(ConstructionSite entity);
    ConstructionSiteSummary toSummaryDto(ConstructionSite entity);




}
