package com.recipesns.post.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostCreateRequestDto {
    private Long memberId;
    private String content;
    private List<Image> images;
    private List<Food> foods;

    @Builder
    public PostCreateRequestDto(Long memberId, String content, List<Image> images, List<Food> foods) {
        this.memberId = memberId;
        this.content = content;
        this.images = images;
        this.foods = foods;
    }
}
