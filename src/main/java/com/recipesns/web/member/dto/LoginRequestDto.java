package com.recipesns.web.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotBlank(message = "아이디를 입력해주세요")
    private String username;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @Builder
    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
