package com.ricardocampos.constructionapp.dto.product;

import java.util.UUID;

public record ProductSummaryDto(
        UUID id,
        String name,
        String reference
) {
}
