package com.recipesns.food.repository;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;
import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcFoodRepository implements FoodRepository {

    private final SpringDataJdbcFoodRepository repository;

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public Food findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Food> findAll(FoodSearchRequestDto cond) {
        String foodName = cond.getFoodName();
        Integer page = cond.getPage();
        Integer size = cond.getSize();
        PageRequest pageable = PageRequest.of(page - 1, size);

        if (StringUtils.hasText(foodName)) {
            return repository.findByFoodNameContaining(foodName, pageable);
        }

        return repository.findAll(pageable);
    }

    @Override
    public void update(Food food) {
        Food findFood = repository.findByFoodCode(food.getFoodCode());
        findFood.updateFood(food);
        repository.save(findFood);
    }
}
