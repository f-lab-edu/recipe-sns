package com.recipesns.post.controller.dto;

import lombok.Getter;

@Getter
public class FoodRequest {
    private Long foodId;

    public FoodRequest() {
    }

    public FoodRequest(Long foodId) {
        this.foodId = foodId;
    }
}
