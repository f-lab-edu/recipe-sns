package com.recipesns.web.exception;

import com.recipesns.web.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    private static final int DEFAULT_ERROR_CODE = 4000;

    @ExceptionHandler(SystemException.class)
    public ApiResponse<Void> SystemExceptionHandler(SystemException e) {
        return ApiResponse.systemException(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ApiResponse<Void> BusinessExceptionHandler(BusinessException e) {
        return ApiResponse.businessException(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ApiResponse.methodArgumentNotValidException(DEFAULT_ERROR_CODE, errorMessage);
    }

}
