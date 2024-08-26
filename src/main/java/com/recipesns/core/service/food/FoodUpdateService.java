package com.recipesns.core.service.food;

import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.service.food.provider.responce.FoodData;
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
