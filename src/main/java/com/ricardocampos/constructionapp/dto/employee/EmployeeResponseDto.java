package com.ricardocampos.constructionapp.dto.employee;

import com.ricardocampos.constructionapp.enums.EmployeeRole;

import java.util.UUID;

public record EmployeeResponseDto(
        UUID id,
        String name,
        String password,
        String phone,
        String email,
        EmployeeRole role,
        boolean active
) {
}
