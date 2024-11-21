package com.recipesns.core.service.food.provider.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodData {
    @JsonProperty("DESC_KOR")
    private String foodName;

    @JsonProperty("SERVING_SIZE")
    private int foodSize;

    @JsonProperty("FOOD_CD")
    private String foodCode;

    @JsonProperty("NUTR_CONT2")
    private double carbohydrate;

    @JsonProperty("NUTR_CONT3")
    private double protein;

    @JsonProperty("NUTR_CONT1")
    private double calorie;

    @JsonProperty("NUTR_CONT4")
    private double fat;

    public FoodData(String foodName, int foodSize, String foodCode, double carbohydrate, double protein, double calorie, double fat) {
        this.foodName = foodName;
        this.foodSize = foodSize;
        this.foodCode = foodCode;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.calorie = calorie;
        this.fat = fat;
    }
}
