package com.recipesns.web.member.dto;

import lombok.Builder;
import lombok.Getter;

import static com.recipesns.web.exception.BusinessError.*;

@Getter
public class LoginRequestDto {

    private String username;
    private String password;

    @Builder
    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        if (!checkUsername()) {
            throw MEMBER_LOGIN_USERNAME_ERROR.exception();
        }
        if (!checkPassword()) {
            throw MEMBER_LOGIN_PASSWORD_ERROR.exception();
        }
        return true;
    }

    private boolean checkUsername() {
        if (username == null) {
            return false;
        }
        return !username.isBlank();
    }

    private boolean checkPassword() {
        if (password == null) {
            return false;
        }
        return !password.isBlank();
    }
}
