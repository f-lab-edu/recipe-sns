package com.recipesns.core.model.food;

import com.recipesns.core.model.BaseEntity;
import com.recipesns.core.service.food.provider.responce.FoodData;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;
    private String foodName;
    private Integer foodSize;
    private String foodCode;
    private double carbohydrate;
    private double protein;
    private double calorie;
    private double fat;

    @Builder
    public Food(String foodName, Integer foodSize, String foodCode, double carbohydrate, double protein, double fat, double calorie) {
        this.foodName = foodName;
        this.foodSize = foodSize;
        this.foodCode = foodCode;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.calorie = calorie;
    }

    public void updateFood(FoodData foodData) {
        this.foodName = foodData.getFoodName();
        this.foodSize = foodData.getFoodSize();
        this.foodCode = foodData.getFoodCode();
        this.carbohydrate = foodData.getCarbohydrate();
        this.protein = foodData.getProtein();
        this.fat = foodData.getFat();
        this.calorie = foodData.getCalorie();
    }
}
