package com.recipesns.food.controller.dto;

import lombok.Getter;

@Getter
public class FoodSearchRequestDto {

    private String FoodName;
    private Integer page;
    private Integer size;

    public FoodSearchRequestDto(String foodName, Integer page, Integer size) {
        FoodName = foodName;
        this.page = page;
        this.size = size;
    }
}
