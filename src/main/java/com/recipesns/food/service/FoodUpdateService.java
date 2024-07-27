package com.recipesns.food.service;

import com.recipesns.food.provider.responce.FoodData;
import com.recipesns.food.repository.JdbcFoodBulkUpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

    private final JdbcFoodBulkUpdateRepository jdbcFoodBulkUpdateRepository;

    @Transactional
    public Integer update(List<FoodData> foodList) {

        jdbcFoodBulkUpdateRepository.bulkUpdate(foodList);

        return foodList.size();
    }
}
