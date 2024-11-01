package com.recipesns.core.service.member.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberFollowServiceRequest {
    private Long followerId;
    private Long followingId;

    @Builder
    private MemberFollowServiceRequest(Long followerId, Long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public static MemberFollowServiceRequest of(Long followerId, Long followingId) {
        return MemberFollowServiceRequest
                .builder()
                .followerId(followerId)
                .followingId(followingId)
                .build();
    }
}
