package com.ricardocampos.constructionapp.dto.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record SupplierCreateDto(
        @NotBlank(message = "O nome é obrigatório.")
        String name,
        @NotBlank(message = "O nif é obrigatório.")
        @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "NIF inválido.")
        String nif,
        String address,
        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Número de telemóvel inválido.")
        String phone,
        @Email(message = "Email inválido.")
        String email

) {
}
