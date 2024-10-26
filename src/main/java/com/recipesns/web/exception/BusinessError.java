package com.recipesns.web.exception;

import lombok.Getter;

@Getter
public enum BusinessError {

    // POST 4000번대
    DUPLICATE_LIKE_ERROR(4001, "좋아요를 중복으로 할 수 없습니다"),
    POST_LIKE_NOT_FOUND_ERROR(4002, "좋아요 데이터를 찾을 수 없습니다"),
    POST_NOT_FOUND_ERROR(4003, "게시물을 찾을 수 없습니다"),
    POST_FODD_NOT_FOUND_EROOR(4004, "선택한 음식을 찾을 수 없습니다."),

    // MEMBER 4100번대
    MEMBER_DUPLICATE_ERROR(4101, "중복된 아이디를 사용할 수 없습니다"),
    MEMBER_NOT_FOUND_ERROR(4102, "아이디 또는 비밀번호를 확인해주세요"),
    MEMBER_PASSWORD_CONFIRMATION_ERROR(4103, "확인 비밀번호를 확인해주세요"),
    MEMBER_USERNAME_ERROR(4104, "아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다"),
    MEMBER_PASSWORD_ERROR(4105, "비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다"),
    MEMBER_NICKNAME_ERROR(4106, "닉네임을 입력해주세요"),
    MEMBER_LOGIN_ERROR(4107, "로그인 후 이용할 수 있습니다"),
    MEMBER_LOGIN_USERNAME_ERROR(4108, "아이디를 입력해주세요"),
    MEMBER_LOGIN_PASSWORD_ERROR(4109, "비밀번호를 입력해주세요");

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
