package com.recipesns.web.member.dto;

import lombok.Builder;
import lombok.Getter;

import static com.recipesns.web.exception.BusinessError.*;

@Getter
public class MemberCreateRequestDto {

    private static final String USERNAME_VALIDATION_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,12}$";
    private static final String CREDENTIALS_VALIDATION_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$";

    private String username;

    private String password;

    private String confirmPassword;

    private String nickname;

    @Builder
    public MemberCreateRequestDto(String username, String password, String confirmPassword, String nickname) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.nickname = nickname;
    }

    public boolean validate() {
        if (!checkUsername()) {
            throw MEMBER_USERNAME_ERROR.exception();
        }
        if (!checkPassword()) {
            throw MEMBER_PASSWORD_ERROR.exception();
        }
        if (!checkConfirmPassword()) {
            throw MEMBER_PASSWORD_CONFIRMATION_ERROR.exception();
        }
        if (!checkNickname()) {
            throw MEMBER_NICKNAME_ERROR.exception();
        }
        return true;
    }

    private boolean checkUsername() {
        if (username == null) {
            return false;
        }
        if (username.isBlank()) {
            return false;
        }
        return username.matches(USERNAME_VALIDATION_PATTERN);
    }

    private boolean checkPassword() {
        if (password == null) {
            return false;
        }
        if (password.isBlank()) {
            return false;
        }
        return password.matches(CREDENTIALS_VALIDATION_PATTERN);
    }

    private boolean checkConfirmPassword() {
        if (confirmPassword == null) {
            return false;
        }
        if (confirmPassword.isBlank()) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    private boolean checkNickname() {
        if (nickname == null) {
            return false;
        }
        return !nickname.isBlank();
    }
}
