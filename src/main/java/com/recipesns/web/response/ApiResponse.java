package com.recipesns.web.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <Void> ApiResponse<Void> success() {
        return new ApiResponse<>(2000, null, null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(2000, null, data);
    }

    public static <Void> ApiResponse<Void> systemException(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public static ApiResponse<Void> businessException(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}
