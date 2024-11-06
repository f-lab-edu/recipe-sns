package com.recipesns.core.service.post.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostListServiceRequest {

    private Long memberId;
    private int page;
    private int size;

    @Builder
    public PostListServiceRequest(Long memberId, int page, int size) {
        this.memberId = memberId;
        this.page = page;
        this.size = size;
    }

    public static PostListServiceRequest of(Long memberId, int page, int size) {
        return new PostListServiceRequest(memberId, page, size);
    }
}
