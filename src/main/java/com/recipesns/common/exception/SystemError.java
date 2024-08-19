package com.recipesns.common.exception;

import lombok.Getter;

@Getter
public enum SystemError {

    POST_IMAGE_CONVERTER_ERROR(5000, "이미지 리스트를 JSON 문자열로 변환할 수 없습니다"),
    JSON_CONVERTER_ERROR(5001, "JSON 문자열을 이미지 리스트로 변환할 수 없습니다");

    private final int code;
    private final String message;

    SystemError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
