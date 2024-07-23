package com.recipesns.food.service;

import com.recipesns.food.domain.Food;
import java.util.List;

public interface FoodProvider {
    List<Food> getFoods(String today);
}
