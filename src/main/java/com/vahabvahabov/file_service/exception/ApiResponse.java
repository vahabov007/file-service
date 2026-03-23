package com.vahabvahabov.file_service.exception;

import lombok.Data;

import java.time.Instant;

@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private int status;
    private String path;
    private Instant time = Instant.now();
    private T data;
    private Object errors;

    public static <T> ApiResponse<T> success(String message, T data, int status, String path) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setStatus(status);
        apiResponse.setPath(path);
        return apiResponse;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        return apiResponse;
    }
    public static <T> ApiResponse<T> error(String message, T data, Object errors) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setErrors(errors);
        return apiResponse;
    }

    public static <T> ApiResponse<T> error(String message, T data, int status, String path) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setStatus(status);
        apiResponse.setPath(path);
        return apiResponse;
    }




}
