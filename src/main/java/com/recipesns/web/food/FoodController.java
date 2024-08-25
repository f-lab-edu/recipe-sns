package com.recipesns.web.food;

import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.core.model.food.Food;
import com.recipesns.core.service.food.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/foods")
    public List<Food> getAll(@ModelAttribute FoodSearchRequestDto dto) {
        return foodService.getFoods(dto);
    }
}
