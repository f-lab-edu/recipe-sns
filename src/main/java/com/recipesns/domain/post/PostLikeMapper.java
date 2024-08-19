package com.recipesns.domain.post;

import org.springframework.stereotype.Component;

@Component
public class PostLikeMapper {

    public PostLike from(Long postId, Long memberId) {
        return PostLike.builder()
                .memberId(memberId)
                .postId(postId)
                .build();

    }

}
