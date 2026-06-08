package com.ricardocampos.constructionapp.dto.fuelrecord;

import com.ricardocampos.constructionapp.dto.vehicle.VehicleSummaryDto;
import com.ricardocampos.constructionapp.dto.employee.EmployeeSummaryDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record FuelRecordResponseDto(
        UUID id,
        LocalDateTime recordDate,
        BigDecimal liters,
        BigDecimal kmHours,
        BigDecimal cost,
        EmployeeSummaryDto employee,
        VehicleSummaryDto vehicle
) {
}
