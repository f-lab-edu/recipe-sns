package com.recipesns.web.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateRequestDto {
    private String username;
    private String password;
    private String nickname;

    @Builder
    public MemberCreateRequestDto(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
