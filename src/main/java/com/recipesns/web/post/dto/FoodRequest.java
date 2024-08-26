package com.recipesns.web.post.dto;

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
