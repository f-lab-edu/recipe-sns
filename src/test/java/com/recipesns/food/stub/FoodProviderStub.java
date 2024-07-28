package com.recipesns.food.stub;

import com.recipesns.food.provider.responce.FoodData;
import com.recipesns.food.service.FoodProvider;

import java.util.List;

public class FoodProviderStub implements FoodProvider {
    @Override
    public List<FoodData> getFoods(String today, Integer startPage, Integer endPage) {
        FoodData food1 = new FoodData("음식 이름1", 141, "DS1234", 50.2, 30.2, 12, 511);
        FoodData food2 = new FoodData("음식 이름2", 142, "DS1235", 50.2, 30.2, 12, 511);
        FoodData food3 = new FoodData("음식 이름3", 143, "DS1236", 50.2, 30.2, 12, 511);
        return List.of(food1, food2, food3);
    }
}
