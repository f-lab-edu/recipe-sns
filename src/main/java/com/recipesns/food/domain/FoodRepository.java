package com.recipesns.food.domain;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;
import com.recipesns.food.provider.responce.FoodData;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    List<Food> findAll(FoodSearchRequestDto cond);
    Integer bulkUpdate(List<FoodData> foodList);
}
