package com.recipesns.food.domain;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    List<Food> findAll(FoodSearchRequestDto cond);
    void update(Food food);
}
