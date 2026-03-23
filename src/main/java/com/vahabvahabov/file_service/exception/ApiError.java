package com.vahabvahabov.file_service.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError <T> {
    private final String message;
    private T data;
    private final String errorCode;
    private final int status;
    private final LocalDateTime timestamp;

    public ApiError(String message, String errorCode, int status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}