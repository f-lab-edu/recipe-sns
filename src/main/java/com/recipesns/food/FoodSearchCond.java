package com.recipesns.food;

import lombok.Data;

@Data
public class FoodSearchCond {

    private String foodName;

    public FoodSearchCond() {}

    public FoodSearchCond(String foodName) {
        this.foodName = foodName;
    }
}
