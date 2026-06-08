package com.ricardocampos.constructionapp.dto.supplier;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record SupplierProductCreateDto(
        @NotNull(message = "O fornecedor é obrigatório.")
        UUID supplierId,
        @NotNull(message = "O produto é obrigatório.")
        UUID productId,
        @NotNull(message = "O fornecedor é obrigatório.")
        @Positive(message = "O preço tem de ser maior que 0.")
        BigDecimal price,
        @NotNull(message = "O prazo de entrega é obrigatório.")
        @Positive(message = "O prazo tem de ser maior que 0.")
        Integer leadTime

) {
}
