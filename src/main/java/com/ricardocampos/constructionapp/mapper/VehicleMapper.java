package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.vehicle.VehicleCreateDto;
import com.ricardocampos.constructionapp.dto.vehicle.VehicleResponseDto;
import com.ricardocampos.constructionapp.dto.vehicle.VehicleSummaryDto;
import com.ricardocampos.constructionapp.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface VehicleMapper {

    Vehicle toEntity(VehicleCreateDto dto);
    VehicleResponseDto toDto(Vehicle entity);
    VehicleSummaryDto toSummaryDto(Vehicle entity);
}
