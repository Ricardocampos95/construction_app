package com.ricardocampos.constructionapp.dto.employee;

import com.ricardocampos.constructionapp.enums.EmployeeRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record EmployeeCreateDto(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotBlank(message = "A password é obrigatória.")
        String password,
        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Número de telemóvel inválido.")
        String phone,
        @Email(message = "Email inválido.")
        String email,
        @NotNull(message = "A função do funcionário é de preenchimento obrigatório.")
        EmployeeRole role
) {
}
