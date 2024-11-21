package com.recipesns.web.member.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberFollowRequest {
    private Long followingId;

    @Builder
    public MemberFollowRequest(Long followingId) {
        this.followingId = followingId;
    }
}
