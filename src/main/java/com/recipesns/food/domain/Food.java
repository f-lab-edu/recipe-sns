package com.recipesns.food.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Food {
    private Long id;
    private String foodName;
    private Integer foodSize;
    private double carbohydrate;
    private double protein;

    private double calorie;
    private double fat;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Food(String foodName, Integer foodSize, double carbohydrate, double protein, double fat, double calorie) {
        this.foodName = foodName;
        this.foodSize = foodSize;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.calorie = calorie;
        this.createdAt = LocalDateTime.now();
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodSize=" + foodSize +
                ", carbohydrate=" + carbohydrate +
                ", protein=" + protein +
                ", calorie=" + calorie +
                ", fat=" + fat +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
