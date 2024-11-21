package com.recipesns.core.service.post.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostLikeServiceRequest {
    private Long postId;
    private Long memberId;

    @Builder
    private PostLikeServiceRequest(Long postId, Long memberId) {
        this.postId = postId;
        this.memberId = memberId;
    }

    public static PostLikeServiceRequest of(Long postId, Long memberId) {
        return new PostLikeServiceRequest(postId, memberId);
    }
}
