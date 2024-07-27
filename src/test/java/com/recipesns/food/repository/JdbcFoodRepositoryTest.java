package com.recipesns.food.repository;

import com.recipesns.food.controller.dto.FoodSearchRequestDto;
import com.recipesns.food.domain.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class JdbcFoodRepositoryTest {

    @Autowired
    JdbcFoodRepository jdbcFoodRepository;

    @Test
    void save() {
        Food food = new Food("음식 이름", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food savedFood = this.jdbcFoodRepository.save(food);
        assertThat(savedFood.getFoodCode()).isEqualTo(food.getFoodCode());
    }

    @Test
    void findById() {
        Food food = new Food("음식 이름", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food savedFood = this.jdbcFoodRepository.save(food);
        Food findFood = this.jdbcFoodRepository.findById(savedFood.getId());
        assertThat(savedFood.getFoodCode()).isEqualTo(findFood.getFoodCode());
    }

    @Test
    void findAll() {
        Food food1 = new Food("음식 이름1", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food food2 = new Food("음식 이름2", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food food3 = new Food("음식 이름3", 140, "DS1234", 50.2, 30.2, 12, 511);

        this.jdbcFoodRepository.save(food1);
        this.jdbcFoodRepository.save(food2);
        this.jdbcFoodRepository.save(food3);

        List<Food> foodList1 = this.jdbcFoodRepository.findAll(new FoodSearchRequestDto(null, 1, 10));
        assertThat(foodList1.size()).isEqualTo(3);

        List<Food> foodList2 = this.jdbcFoodRepository.findAll(new FoodSearchRequestDto("이름1", 1, 1));
        assertThat(foodList2.size()).isEqualTo(1);
    }
}