package com.ricardocampos.constructionapp.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record ClientPatchDto(
        String name,
        @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "NIF inválido.")
        String nif,
        String address,
        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Número de telemóvel inválido.")
        String phoneNumber,
        @Email(message = "Email inválido.")
        String email
) {
}
