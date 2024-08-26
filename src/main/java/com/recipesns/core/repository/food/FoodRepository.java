package com.recipesns.core.repository.food;

import com.recipesns.core.model.food.Food;
import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.core.service.food.provider.responce.FoodData;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Long id);
    List<Food> findAll(FoodSearchRequestDto cond);
    Integer bulkUpdate(List<FoodData> foodList);
}
