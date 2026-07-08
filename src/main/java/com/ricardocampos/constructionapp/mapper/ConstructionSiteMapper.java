package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.constructionsite.*;
import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.entities.ConstructionSiteVehicle;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring",
        uses = {ClientMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConstructionSiteMapper {


    @Mapping(target = "client.id", source = "clientId")
    ConstructionSite toEntity(ConstructionSiteCreateDto dto);
    ConstructionSiteResponseDto toDto(ConstructionSite entity);
    ConstructionSiteSummary toSummaryDto(ConstructionSite entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ConstructionSiteUpdateDto dto, @MappingTarget ConstructionSite entity);




}
