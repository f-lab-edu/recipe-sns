package com.recipesns.food.repository;

import com.recipesns.food.domain.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class JdbcFoodRepositoryTest {

    @Autowired
    JdbcFoodRepository jdbcFoodRepository;

    @Test
    void save() {
        Food food = new Food("음식 이름", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food savedFood = this.jdbcFoodRepository.save(food);
        assertThat(savedFood.getId()).isEqualTo(1L);
    }
}