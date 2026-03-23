package com.vahabvahabov.file_service.exception;

import com.vahabvahabov.file_service.exception.exceptions.FileSyncException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice @Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception exception) {
        log.error("Unexpected error occurred", exception);

        ApiError error = new ApiError("An unexpected error occurred",
                                     "INTERNAL_SERVER_ERROR",
                                               HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(Exception exception) {
        log.warn("Validation error occurred");

        ApiError error = new ApiError(exception.getMessage(),
                           "BAD_REQUEST",
                                     HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileSyncException.class)
    public ResponseEntity<ApiError> handleFileSyncException(Exception exception) {
        log.warn("File Sync Error occurred");
        ApiError apiError = new ApiError(exception.getMessage(),
                               "INTERNAL_SERVER_ERROR",
                                         HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}