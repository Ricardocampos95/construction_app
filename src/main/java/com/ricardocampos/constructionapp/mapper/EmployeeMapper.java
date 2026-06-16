package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.employee.EmployeeCreateDto;
import com.ricardocampos.constructionapp.dto.employee.EmployeeResponseDto;
import com.ricardocampos.constructionapp.dto.employee.EmployeeSummaryDto;
import com.ricardocampos.constructionapp.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EmployeeMapper {

    Employee toEntity(EmployeeCreateDto dto);
    EmployeeResponseDto toDto(Employee entity);
    EmployeeSummaryDto toSummaryDto(Employee entity);
}
