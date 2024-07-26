package com.recipesns.food;

import lombok.Getter;

@Getter
public class FoodSearchCond {

    private String foodName;
    private Integer page;
    private Integer size;

    public FoodSearchCond() {}

    public FoodSearchCond(String foodName, Integer page, Integer size) {
        this.foodName = foodName;
        this.page = page;
        this.size = size;
    }
}
