package com.recipesns.core.service.post.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class PostServiceRequest {

    private final String content;
    private final Long memberId;
    private final List<Long> foods;
    private final List<Map<String, String>> postImages;

    @Builder
    private PostServiceRequest(String content, Long memberId, List<Long> foods, List<Map<String, String>> postImages) {
        this.content = content;
        this.memberId = memberId;
        this.foods = foods;
        this.postImages = postImages;
    }

    public static PostServiceRequest of(String content, Long memberId, List<Long> foods, List<Map<String, String>> postImages) {
        return new PostServiceRequest(content, memberId, foods, postImages);
    }
}
