package com.recipesns.core.service.food;

import com.recipesns.core.service.food.provider.responce.FoodData;

import java.util.List;

public interface FoodProvider {
    List<FoodData> getFoods(String today, Integer startPage, Integer endPage);
}
