package com.recipesns.food.controller;

import com.recipesns.food.FoodSearchCond;
import com.recipesns.food.domain.Food;
import com.recipesns.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/foods")
    public List<Food> getAll(@RequestParam String foodName) {
        return foodService.getFoods(new FoodSearchCond(foodName));
    }
}
