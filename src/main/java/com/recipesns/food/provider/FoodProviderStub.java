package com.recipesns.food.provider;

import com.recipesns.food.domain.Food;
import com.recipesns.food.service.FoodProvider;

import java.util.List;

public class FoodProviderStub implements FoodProvider {
    @Override
    public List<Food> getFoods(String today) {
        Food food1 = new Food("음식 이름1", 141, "DS1234", 50.2, 30.2, 12, 511);
        Food food2 = new Food("음식 이름2", 142, "DS1235", 50.2, 30.2, 12, 511);
        Food food3 = new Food("음식 이름3", 143, "DS1236", 50.2, 30.2, 12, 511);
        return List.of(food1, food2, food3);
    }
}
