package com.recipesns.food.service;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;
import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodProvider foodProvider;

    @Transactional
    public Integer updateFood(String today) {
        Integer updateCount = 0;
        List<Food> foodList = foodProvider.getFoods(today);
        for (Food food : foodList) {
            foodRepository.update(food);
            updateCount++;
        }
        return updateCount;
    }

    public List<Food> getFoods(FoodSearchRequestDto dto) {
        return foodRepository.findAll(dto);
    }
}
