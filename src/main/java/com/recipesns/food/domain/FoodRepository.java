package com.recipesns.food.domain;

import com.recipesns.food.FoodSearchCond;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    List<Food> findAll(FoodSearchCond cond);
    void update(Food food);
}
