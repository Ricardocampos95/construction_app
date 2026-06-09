package com.ricardocampos.constructionapp.dto.product;

import com.ricardocampos.constructionapp.enums.UnitType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductCreateDto(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotNull(message = "A unidade é obrigatória.")
        UnitType unitType,
        @NotBlank(message = "A referencia é obrigatória.")
        String reference,
        @NotNull(message = "O stock minimo é obrigatório.")
        @PositiveOrZero(message = "O stock minimo não pode ser negativo.")
        BigDecimal minStockAlert

) {
}
