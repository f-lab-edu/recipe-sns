package com.recipesns.food.service;

import com.recipesns.food.FoodSearchCond;
import com.recipesns.food.domain.Food;
import com.recipesns.food.repository.JdbcFoodRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final JdbcFoodRepository foodRepository;
    private final FoodProvider foodProvider;

    public void updateFood(String today) {
        List<Food> foodList = foodProvider.getFoods(today);
        for (Food food : foodList) {
            foodRepository.update(food);
        }
    }

    public List<Food> getFoods(FoodSearchCond cond) {
        return foodRepository.findAll(cond);
    }
}
