package com.recipesns.food.service;

import com.recipesns.food.provider.responce.FoodData;

import java.util.List;

public interface FoodProvider {
    List<FoodData> getFoods(String today, Integer startPage, Integer endPage);
}
