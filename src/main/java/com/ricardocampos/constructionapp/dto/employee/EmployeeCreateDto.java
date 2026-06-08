package com.ricardocampos.constructionapp.dto.employee;

import com.ricardocampos.constructionapp.enums.EmployeeRole;

import java.util.UUID;

public record EmployeeCreateDto(
        String name,
        String password,
        String phone,
        String email,
        EmployeeRole role
) {
}
