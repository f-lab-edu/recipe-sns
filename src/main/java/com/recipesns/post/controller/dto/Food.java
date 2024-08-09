package com.recipesns.post.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private Long foodId;

    public Food() {
    }

    public Food(Long foodId) {
        this.foodId = foodId;
    }
}
