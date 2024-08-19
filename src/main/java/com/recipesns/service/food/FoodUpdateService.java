package com.recipesns.service.food;

import com.recipesns.domain.food.FoodRepository;
import com.recipesns.service.food.provider.responce.FoodData;
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
        return foodRepository.bulkUpdate(foodList);
    }
}
