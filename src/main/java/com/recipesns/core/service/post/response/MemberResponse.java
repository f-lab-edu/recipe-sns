package com.recipesns.core.service.post.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private Long memberId;
    private String nickname;

    @Builder
    public MemberResponse(Long memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
