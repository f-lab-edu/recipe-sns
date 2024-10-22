package com.recipesns.repository.food;

import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.core.model.food.Food;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.service.food.provider.responce.FoodData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

@Repository
public class JdbcFoodRepository implements FoodRepository {

    private final JpaFoodRepository jpaRepository;

    public JdbcFoodRepository(JpaFoodRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Food save(Food food) {
        return jpaRepository.save(food);
    }

    @Override
    public Food findById(Long id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Food> findAll(FoodSearchRequestDto cond) {
        String foodName = cond.getFoodName();
        Integer page = cond.getPage();
        Integer size = cond.getSize();
        PageRequest pageable = PageRequest.of(page - 1, size);

        if (StringUtils.hasText(foodName)) {
            return jpaRepository.findByFoodNameContaining(foodName, pageable);
        }

        Page<Food> foods = jpaRepository.findAll(pageable);
        return foods.getContent();
    }

    @Override
    public Integer bulkUpdate(List<FoodData> foodList) {

        List<String> foodCodes = foodList.stream()
                .map(FoodData::getFoodCode)
                .toList();

        List<Food> foods = jpaRepository.findAllByFoodCodeIn(foodCodes);

        IntStream.range(0, foodList.size())
                .forEach(i -> foods.get(i).updateFood(foodList.get(i)));
        return foods.size();
    }
}
