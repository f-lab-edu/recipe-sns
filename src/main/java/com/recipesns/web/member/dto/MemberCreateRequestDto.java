package com.recipesns.web.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateRequestDto {

    private static final String USERNAME_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()-+=]).{8,}$";

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = USERNAME_PATTERN, message = "아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = PASSWORD_PATTERN, message = "비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "확인 비밀번호를 입력해주세요")
    private String confirmPassword;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

    @Builder
    public MemberCreateRequestDto(String username, String password, String confirmPassword, String nickname) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.nickname = nickname;
    }

    public boolean checkPassword() {
        return password.equals(confirmPassword);
    }
}
