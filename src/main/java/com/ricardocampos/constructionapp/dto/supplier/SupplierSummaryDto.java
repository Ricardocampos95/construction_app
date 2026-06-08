package com.ricardocampos.constructionapp.dto.supplier;

import java.util.UUID;

public record SupplierSummaryDto(
        UUID id,
        String name,
        String phone,
        String email

) {
}
