package com.recipesns.core.service.post.response;

import com.recipesns.core.model.post.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
public class PostResponse {
    private final Long id;
    private final List<Map<String, String>> postImages;
    private final String content;
    private final LocalDateTime createdAt;

    @Builder
    private PostResponse(Long id, List<Map<String, String>> postImages, String content, LocalDateTime createdAt) {
        this.id = id;
        this.postImages = postImages;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .postImages(post.getPostImages())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
