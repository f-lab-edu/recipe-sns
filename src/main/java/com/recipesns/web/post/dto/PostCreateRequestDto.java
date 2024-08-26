package com.recipesns.web.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostCreateRequestDto {
    private Long memberId;
    private String content;
    private List<ImageRequest> images;
    private List<FoodRequest> foods;

    @Builder
    public PostCreateRequestDto(Long memberId, String content, List<ImageRequest> images, List<FoodRequest> foods) {
        this.memberId = memberId;
        this.content = content;
        this.images = images;
        this.foods = foods;
    }
}
