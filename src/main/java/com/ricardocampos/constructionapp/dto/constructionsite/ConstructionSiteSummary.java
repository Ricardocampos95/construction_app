package com.ricardocampos.constructionapp.dto.constructionsite;

import com.ricardocampos.constructionapp.dto.employee.EmployeeSummaryDto;
import com.ricardocampos.constructionapp.enums.StockMovementType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ConstructionSiteSummary(
        UUID id,
        BigDecimal quantity,
        StockMovementType movementType,
        LocalDateTime movementDate
) {
}
