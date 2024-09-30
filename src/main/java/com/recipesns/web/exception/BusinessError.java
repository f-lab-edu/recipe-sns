package com.recipesns.web.exception;

import lombok.Getter;

@Getter
public enum BusinessError {

    DUPLICATE_LIKE_ERROR(4001, "좋아요를 중복으로 할 수 없습니다"),
    POST_LIKE_NOT_FOUND_ERROR(4002, "좋아요 데이터를 찾을 수 없습니다"),
    POST_NOT_FOUND_ERROR(4003, "게시물을 찾을 수 없습니다"),

    MEMBER_DUPLICATE_ERROR(4004, "중복된 아이디를 사용할 수 없습니다"),
    MEMBER_NOT_FOUND_ERROR(4005, "아이디 또는 비밀번호를 확인해주세요"),
    MEMBER_PASSWORD_CONFIRMATION_ERROR(4006, "확인 비밀번호를 확인해주세요"),
    MEMBER_LOGIN_ERROR(4007, "로그인 후 이용할 수 있습니다");

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
