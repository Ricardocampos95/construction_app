package com.ricardocampos.constructionapp.dto.client;

import java.util.UUID;

public record ClientResponseDto(
        UUID id,
        String name,
        String address,
        String phoneNumber,
        String email,
        boolean active
) {
}
