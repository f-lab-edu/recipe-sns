package com.recipesns.food.repository;

import com.recipesns.food.domain.Food;
import com.recipesns.food.provider.responce.FoodData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class JdbcFoodBulkUpdateRepositoryTest {

    @Autowired
    JdbcFoodBulkUpdateRepository jdbcFoodBulkUpdateRepository;
    @Autowired
    JdbcFoodRepository jdbcFoodRepository;

    @Test
    void bulkUpdate() {
        Food food1 = new Food("음식 이름1", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food food2 = new Food("음식 이름2", 140, "DS1235", 50.2, 30.2, 12, 511);
        Food food3 = new Food("음식 이름3", 140, "DS1236", 50.2, 30.2, 12, 511);

        Food savedFood1 = this.jdbcFoodRepository.save(food1);
        Food savedFood2 = this.jdbcFoodRepository.save(food2);
        Food savedFood3 = this.jdbcFoodRepository.save(food3);

        FoodData foodData1 = new FoodData("음식 이름1", 141, "DS1234", 50.2, 30.2, 12, 511);
        FoodData foodData2 = new FoodData("음식 이름2", 142, "DS1235", 50.2, 30.2, 12, 511);
        FoodData foodData3 = new FoodData("음식 이름3", 143, "DS1236", 50.2, 30.2, 12, 511);

        List<FoodData> foodList = List.of(foodData1, foodData2, foodData3);
        this.jdbcFoodBulkUpdateRepository.bulkUpdate(foodList);

        Food findFood1 = jdbcFoodRepository.findById(savedFood1.getId());
        Food findFood2 = jdbcFoodRepository.findById(savedFood2.getId());
        Food findFood3 = jdbcFoodRepository.findById(savedFood3.getId());

        assertThat(findFood1.getFoodSize()).isEqualTo(141);
        assertThat(findFood2.getFoodSize()).isEqualTo(142);
        assertThat(findFood3.getFoodSize()).isEqualTo(143);
    }
}