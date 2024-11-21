package com.recipesns.core.service.food;

import com.recipesns.core.service.food.provider.responce.FoodData;
import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.core.model.food.Food;
import com.recipesns.core.repository.food.FoodRepository;
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
