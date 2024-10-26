package com.recipesns.web.post.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class PostCreateRequest {

    private List<Map<String, String>> postImages;
    private List<Long> foods;
    private String content;

    @Builder
    public PostCreateRequest(List<Map<String, String>> postImages, List<Long> foods, String content) {
        this.postImages = postImages;
        this.foods = foods;
        this.content = content;
    }
}
