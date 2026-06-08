package com.ricardocampos.constructionapp.dto.supplier;

import java.util.UUID;

public record SupplierResponseDto(
        UUID id,
        String name,
        String nif,
        String address,
        String phone,
        String email,
        boolean active

) {
}
