package com.recipesns.food.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
public class Food {
    @Id
    private Long id;
    private String foodName;
    private Integer foodSize;
    private String foodCode;
    private double carbohydrate;
    private double protein;
    private double calorie;
    private double fat;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Food(String foodName, Integer foodSize, String foodCode, double carbohydrate, double protein, double fat, double calorie) {
        this.foodName = foodName;
        this.foodSize = foodSize;
        this.foodCode = foodCode;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.calorie = calorie;
        this.createdAt = LocalDateTime.now();
    }

    public void updateFood(Food food) {
        this.foodName = food.getFoodName();
        this.foodSize = food.getFoodSize();
        this.foodCode = food.getFoodCode();
        this.carbohydrate = food.getCarbohydrate();
        this.protein = food.getProtein();
        this.calorie = food.getCalorie();
        this.updatedAt = LocalDateTime.now();
    }
}
