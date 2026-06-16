package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.fuelrecord.FuelRecordCreateDto;
import com.ricardocampos.constructionapp.dto.fuelrecord.FuelRecordResponseDto;
import com.ricardocampos.constructionapp.entities.Employee;
import com.ricardocampos.constructionapp.entities.FuelRecord;
import com.ricardocampos.constructionapp.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {
                VehicleMapper.class,
                EmployeeMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FuelRecordMapper {

     default FuelRecord toEntity(
            FuelRecordCreateDto dto,
            Vehicle vehicle,
            Employee employee
    ) {
         FuelRecord fuelRecord = new FuelRecord();
         fuelRecord.setDate(dto.date());
         fuelRecord.setCost(dto.cost());
         fuelRecord.setLiters(dto.liters());
         fuelRecord.setKmHours(dto.kmHours());
         fuelRecord.setEmployee(employee);
         fuelRecord.setVehicle(vehicle);
         return fuelRecord;
     }

    FuelRecordResponseDto toDto(FuelRecord entity);

}
