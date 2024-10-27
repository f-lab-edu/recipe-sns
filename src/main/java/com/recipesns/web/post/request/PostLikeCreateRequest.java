package com.recipesns.web.post.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLikeCreateRequest {

    private Long postId;

    @Builder
    public PostLikeCreateRequest(Long postId) {
        this.postId = postId;
    }
}
