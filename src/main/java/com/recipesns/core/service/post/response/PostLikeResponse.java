package com.recipesns.core.service.post.response;

import com.recipesns.core.model.post.PostLike;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostLikeResponse {

    private Long postLikeId;
    private Long memberId;
    private Long postId;
    private LocalDateTime createdAt;

    @Builder
    private PostLikeResponse(Long postLikeId, Long memberId, Long postId, LocalDateTime createdAt) {
        this.postLikeId = postLikeId;
        this.memberId = memberId;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public static PostLikeResponse of(PostLike postLike) {
        return PostLikeResponse.builder()
                .postLikeId(postLike.getId())
                .memberId(postLike.getMember().getId())
                .postId(postLike.getPost().getId())
                .createdAt(postLike.getCreatedAt())
                .build();
    }
}
