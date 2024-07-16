package com.recipesns.food.repository;

import com.recipesns.food.domain.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class JdbcFoodRepositoryTest {

    @Autowired
    JdbcFoodRepository jdbcFoodRepository;

    @Test
    @Transactional
    void save() {
        Food food = new Food("음식 이름", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food savedFood = this.jdbcFoodRepository.save(food);
        assertThat(savedFood.getFoodCode()).isEqualTo(food.getFoodCode());
    }

    @Test
    @Transactional
    void findById() {
        Food food = new Food("음식 이름", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food savedFood = this.jdbcFoodRepository.save(food);
        Food findFood = this.jdbcFoodRepository.findById(savedFood.getId());
        assertThat(savedFood.getFoodCode()).isEqualTo(findFood.getFoodCode());
    }

    @Test
    @Transactional
    void update() {
        Food food = new Food("음식 이름1", 140, "DS1234", 50.2, 30.2, 12, 511);

        Food savedFood = this.jdbcFoodRepository.save(food);

        Food updateFood = new Food("음식 이름2", 145, "DS1234", 51.2, 34.2, 12, 5111);

        this.jdbcFoodRepository.update(updateFood);
        Food findFood2 = this.jdbcFoodRepository.findById(savedFood.getId());

        assertThat(updateFood.getFoodCode()).isEqualTo(findFood2.getFoodCode());
        assertThat(updateFood.getFoodName()).isEqualTo(findFood2.getFoodName());
        assertThat(updateFood.getCalorie()).isEqualTo(findFood2.getCalorie());
    }
}