package com.ricardocampos.constructionapp.dto.stockmovement;

import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteSummary;
import com.ricardocampos.constructionapp.dto.employee.EmployeeSummaryDto;
import com.ricardocampos.constructionapp.enums.StockMovementType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record StockMovementResponseDto(
        UUID id,
        BigDecimal quantity,
        StockMovementType movementType,
        LocalDateTime movementDate,
        EmployeeSummaryDto employee,
        ConstructionSiteSummary constructionSite

) {
}
