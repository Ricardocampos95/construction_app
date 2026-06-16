package com.ricardocampos.constructionapp.infrastructure.handler;

import java.time.LocalDateTime;

public record ApiErrorResponse(

        LocalDateTime instant,
        int status,
        String error,
        String message,
        String path
) {
}
