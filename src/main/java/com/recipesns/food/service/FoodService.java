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
    public void updateFood(String today) {
        List<Food> foodList = foodProvider.getFoods(today);
        for (Food food : foodList) {
            foodRepository.update(food);
        }
    }

    public List<Food> getFoods(FoodSearchRequestDto dto) {
        return foodRepository.findAll(dto);
    }
}
