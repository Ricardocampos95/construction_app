package com.ricardocampos.constructionapp.dto.vehicle;

import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record VehicleCreateDto(
        @NotBlank(message = "A marca é obrigatória.")
        String brand,
        @NotNull(message = "O tipo do veiculo não pode ser nulo.")
        VehicleType vehicleType,
        @NotBlank(message = "A matricula é obrigatória.")
        @Pattern(
                regexp = "^(([A-Z]{2}-\\d{2}-\\d{2})|(\\d{2}-\\d{2}-[A-Z]{2})|(\\d{2}-[A-Z]{2}-\\d{2})|([A-Z]{2}-\\d{2}-[A-Z]{2}))$",
                flags = {Pattern.Flag.CASE_INSENSITIVE},
                message = "Formato de matrícula inválido. Use o padrão AA-00-00, 00-AA-00 ou AA-00-AA."
        )
        String licensePlate,
        @NotNull(message = "O estado do veiculo não pode ser nulo.")
        VehicleStatus status,
        @NotBlank(message = "O código interno é obrigatório.")
        String internalCode,
        boolean active
) {
}
