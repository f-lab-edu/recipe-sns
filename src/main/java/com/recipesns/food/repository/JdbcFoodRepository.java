package com.recipesns.food.repository;

import com.recipesns.food.FoodSearchCond;
import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcFoodRepository implements FoodRepository {

    private final SpringDataJdbcRepository repository;

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public Food findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Food> findAll(FoodSearchCond cond) {
        String foodName = cond.getFoodName();
        Integer page = cond.getPage();
        Integer size = cond.getSize();
        PageRequest pageable = PageRequest.of(page - 1, size);
        if (StringUtils.hasText(foodName)) {
            System.out.println("이름 있을때");
            return repository.findByFoodNameContaining(foodName, pageable);
        }
        System.out.println("이름 없을때");
        return repository.findAll(pageable);
    }

    @Override
    public void update(Food food) {
        Food findFood = repository.findByFoodCode(food.getFoodCode());
        findFood.setFoodName(food.getFoodName());
        findFood.setFoodSize(food.getFoodSize());
        findFood.setCarbohydrate(food.getCarbohydrate());
        findFood.setProtein(food.getProtein());
        findFood.setFat(food.getFat());
        findFood.setCalorie(food.getCalorie());
        findFood.setUpdatedAt(LocalDateTime.now());
        repository.save(findFood);
    }
}
