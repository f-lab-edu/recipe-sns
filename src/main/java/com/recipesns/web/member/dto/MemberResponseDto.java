package com.recipesns.web.member.dto;

import com.recipesns.core.model.member.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {

    private String username;
    private String nickname;
    private LocalDateTime createdAt;

    @Builder
    public MemberResponseDto(Member member) {
        this.username = member.getUsername();
        this.nickname = member.getNickname();
        this.createdAt = member.getCreatedAt();
    }
}
