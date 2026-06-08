package com.ricardocampos.constructionapp.dto.client;

public record ClientCreateDto(
        String name,
        String address,
        String phoneNumber,
        String email
) {
}
