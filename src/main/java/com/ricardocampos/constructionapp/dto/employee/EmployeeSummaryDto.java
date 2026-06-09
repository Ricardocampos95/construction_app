package com.ricardocampos.constructionapp.dto.employee;

import java.util.UUID;

public record EmployeeSummaryDto(
        UUID id,
        String name
) {
}
