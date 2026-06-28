package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.client.ClientCreateDto;
import com.ricardocampos.constructionapp.dto.client.ClientPatchDto;
import com.ricardocampos.constructionapp.dto.client.ClientResponseDto;
import com.ricardocampos.constructionapp.dto.client.ClientSummaryDto;
import com.ricardocampos.constructionapp.entities.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface ClientMapper {

    Client toEntity(ClientCreateDto dto);
    ClientResponseDto toDto(Client client);
    ClientSummaryDto toSummaryDto(Client client);

    //ignore all null properties from dto
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ClientPatchDto dto, @MappingTarget Client entity);



}
