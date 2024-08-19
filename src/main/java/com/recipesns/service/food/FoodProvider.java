package com.recipesns.service.food;

import com.recipesns.service.food.provider.responce.FoodData;

import java.util.List;

public interface FoodProvider {
    List<FoodData> getFoods(String today, Integer startPage, Integer endPage);
}
