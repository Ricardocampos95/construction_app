package com.ricardocampos.constructionapp.dto.supplier;

import com.ricardocampos.constructionapp.dto.product.ProductSummaryDto;

import java.math.BigDecimal;

public record SupplierProductResponseDto(
        SupplierSummaryDto supplier,
        ProductSummaryDto product,
        BigDecimal price,
        Integer leadTime
) {
}
