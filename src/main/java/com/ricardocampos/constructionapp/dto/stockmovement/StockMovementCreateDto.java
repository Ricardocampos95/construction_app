package com.ricardocampos.constructionapp.dto.stockmovement;

import com.ricardocampos.constructionapp.enums.StockMovementType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record StockMovementCreateDto(
        @Positive(message = "A quantidade tem de ser maior que 0.")
        @NotNull(message = "A quantidade é obrigatória.")
        BigDecimal quantity,
        @NotNull(message = "Obrigatório informar saída ou entrada de produto.")
        StockMovementType movementType,
        @NotNull(message = "A data é obrigatória.")
        LocalDateTime movementDate,
        @NotNull(message = "O produto é obrigatório.")
        UUID productId,
        @NotNull(message = "O funcionário é obrigatório.")
        UUID employeeId,
        UUID constructionSiteId
) {
}
