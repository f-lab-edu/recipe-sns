package com.recipesns.food.service;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;
import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import com.recipesns.food.provider.responce.FoodData;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodUpdateService foodUpdateService;
    private final FoodRepository foodRepository;
    private final FoodProvider foodProvider;

    public Integer updateFood(String today) {
        Integer updateCount = 300;
        Integer startPage = 1;
        Integer endPage = 300;
        while (updateCount % 300 == 0) {
            List<FoodData> foodList = foodProvider.getFoods(today, startPage, endPage);
            updateCount = foodUpdateService.update(foodList);
            startPage = startPage + updateCount;
            endPage = endPage + updateCount;
        }
        return updateCount;
    }

    public List<Food> getFoods(FoodSearchRequestDto dto) {
        return foodRepository.findAll(dto);
    }
}
