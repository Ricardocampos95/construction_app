package com.ricardocampos.constructionapp.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientCreateDto(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotBlank(message = "O nif é obrigatório.")
        @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "NIF inválido.")
        String nif,
        @NotBlank(message = "A morada é obrigatória.")
        String address,
        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Número de telemóvel inválido.")
        String phoneNumber,
        @Email(message = "Email inválido.")
        String email
) {
}
