package com.recipesns.food.domain;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    void update(Food food);
}
