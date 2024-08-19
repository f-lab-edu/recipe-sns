package com.recipesns.domain.food;

import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.service.food.provider.responce.FoodData;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    List<Food> findAll(FoodSearchRequestDto cond);
    Integer bulkUpdate(List<FoodData> foodList);
}
