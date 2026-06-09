package com.ricardocampos.constructionapp.dto.fuelrecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record FuelRecordCreateDto(
        LocalDateTime date,
        BigDecimal liters,
        BigDecimal kmHours,
        BigDecimal cost,
        UUID employeeId,
        UUID vehicleId

) {
}
