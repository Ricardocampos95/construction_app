package com.ricardocampos.constructionapp.dto.product;

import com.ricardocampos.constructionapp.enums.UnitType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDto(
        UUID id,
        String name,
        UnitType unitType,
        String reference,
        BigDecimal minStockAlert
) {
}
