package com.recipesns.web.exception;

import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {

    private final int code;

    public SystemException(int code, String message) {
        super(message);
        this.code = code;
    }
}
