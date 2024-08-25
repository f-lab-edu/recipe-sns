package com.recipesns.common.exception;

import lombok.Getter;

@Getter
public enum BusinessError {

    DUPLICATE_LIKE_ERROR(4000, "좋아요를 중복으로 할 수 없습니다"),
    POST_LIKE_NOT_FOUND_ERROR(4001, "좋아요 데이터를 찾을 수 없습니다"),
    POST_NOT_FOUND_ERROR(4002, "게시물을 찾을 수 없습니다");

    private final int code;
    private final String message;

    BusinessError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException exception() {
        return new BusinessException(this.code, this.message);
    }
}