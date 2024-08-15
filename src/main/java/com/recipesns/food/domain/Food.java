package com.recipesns.food.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("FOOD")
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
        this.updatedAt = LocalDateTime.now();
    }
}
