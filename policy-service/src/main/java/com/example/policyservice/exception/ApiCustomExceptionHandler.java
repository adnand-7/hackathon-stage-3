package com.example.policyservice.exception;

import com.example.policyservice.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiCustomExceptionHandler {
    @ExceptionHandler(GlobalExceptionHandler.class)
    public ResponseEntity<ApiResponseDto> customExceptionHandler(GlobalExceptionHandler exceptionHandler) {
        return new ResponseEntity<>(ApiResponseDto.builder()
                .message(exceptionHandler.getMessage())
                .success(false)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
