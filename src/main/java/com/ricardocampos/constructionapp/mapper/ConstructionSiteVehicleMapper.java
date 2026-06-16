package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.constructionsitevehicle.ConstructionSiteVehicleCreateDto;
import com.ricardocampos.constructionapp.dto.constructionsitevehicle.ConstructionSiteVehicleResponseDto;
import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.entities.ConstructionSiteVehicle;
import com.ricardocampos.constructionapp.entities.Vehicle;
import com.ricardocampos.constructionapp.entities.keys.ConstructionSiteVehicleId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {
                ConstructionSiteMapper.class,
                VehicleMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConstructionSiteVehicleMapper {


    default ConstructionSiteVehicle toEntity(
                        ConstructionSiteVehicleCreateDto dto,
                        ConstructionSite constructionSite,
                        Vehicle vehicle
    ) {
        ConstructionSiteVehicleId id = new ConstructionSiteVehicleId(
                    constructionSite.getId(),
                    vehicle.getId()
        );

        ConstructionSiteVehicle constructionSiteVehicle = new ConstructionSiteVehicle();

        constructionSiteVehicle.setId(id);
        constructionSiteVehicle.setStartDate(dto.startDate());
        constructionSiteVehicle.setEndDate(dto.endDate());
        constructionSiteVehicle.setConstructionSite(constructionSite);
        constructionSiteVehicle.setVehicle(vehicle);
        return constructionSiteVehicle;
    }


    ConstructionSiteVehicleResponseDto toDto(ConstructionSiteVehicle entity);
}
