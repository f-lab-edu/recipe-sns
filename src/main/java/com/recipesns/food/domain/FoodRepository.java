package com.recipesns.food.domain;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    Food update(Long id, Food food);
    void delete(Long id);
}
