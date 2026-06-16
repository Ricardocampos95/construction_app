package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.client.ClientCreateDto;
import com.ricardocampos.constructionapp.dto.client.ClientResponseDto;
import com.ricardocampos.constructionapp.dto.client.ClientSummaryDto;
import com.ricardocampos.constructionapp.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface ClientMapper {

    Client toEntity(ClientCreateDto dto);
    ClientResponseDto toDto(Client client);
    ClientSummaryDto toSummaryDto(Client client);



}
