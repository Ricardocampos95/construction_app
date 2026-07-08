package com.ricardocampos.constructionapp.infrastructure.handler;

import com.ricardocampos.constructionapp.exceptions.AlreadyExistsException;
import com.ricardocampos.constructionapp.exceptions.BusinessException;
import com.ricardocampos.constructionapp.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException e,
                                                                   HttpServletRequest request
    ) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusiness(BusinessException e,
                                                           HttpServletRequest request
    ){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleAlreadyExists(AlreadyExistsException e,
                                                                HttpServletRequest request
    ){
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception e,
                                                                   HttpServletRequest request){

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);

    }


}
