package com.recipesns.food.service;

import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import com.recipesns.food.provider.responce.FoodData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

    private final FoodRepository foodRepository;

    @Transactional
    public Integer update(List<FoodData> foodList) {
        Integer updateCount = 0;
        for (FoodData food : foodList) {
            foodRepository.update(new Food(
                    food.getFoodName(),
                    food.getFoodSize(),
                    food.getFoodCode(),
                    food.getCarbohydrate(),
                    food.getProtein(),
                    food.getFat(),
                    food.getCalorie()
            ));
            updateCount++;
        }
        return updateCount;
    }
}
