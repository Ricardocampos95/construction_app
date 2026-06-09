package com.ricardocampos.constructionapp.dto.fuelrecord;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record FuelRecordCreateDto(
        @NotNull(message = "A data é obrigatória.")
        @PastOrPresent(message = "A data tem de ser anterior ou atual.")
        LocalDateTime date,
        @NotNull(message = "É obrigatório inserir os litros.")
        @Positive(message = "Os litros não podem ser zero.")
        @Digits(integer= 10, fraction= 2, message = "O volume deve ter no máximo 10 dígitos inteiros e 2 casas decimais.")
        BigDecimal liters,
        @NotNull(message = "É obrigatório inserir os km ou horas do veículo.")
        @PositiveOrZero(message = "As horas ou km têm de ser positivos.")
        @Digits(integer= 10, fraction= 2, message = "O valor deve ter no máximo 10 dígitos inteiros e 2 casas decimais.")
        BigDecimal kmHours,
        @NotNull(message = "É obrigatório inserir o preço do combustível.")
        @Positive(message = "O valor do combustível tem de ser maior que zero.")
        @Digits(integer= 5, fraction= 2, message = "O preço deve ter no máximo 5 dígitos inteiros e 2 casas decimais.")
        BigDecimal cost,

        @NotNull(message = "É obrigatório inserir o funcionário.")
        UUID employeeId,
        @NotNull(message = "É obrigatório inserir o veículo.")
        UUID vehicleId

) {
}
