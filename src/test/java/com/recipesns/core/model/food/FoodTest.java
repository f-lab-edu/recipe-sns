package com.recipesns.core.model.food;

import com.recipesns.core.service.food.provider.responce.FoodData;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class FoodTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void test() {
        Food food = Food.builder()
                .foodName("음식 이름1")
                .foodSize(140)
                .foodCode("DS1234")
                .carbohydrate(50.2)
                .protein(30.2)
                .fat(12)
                .calorie(511)
                .build();

        entityManager.persist(food);
        FoodData foodData1 = new FoodData("음식 이름12", 141, "DS1234", 50.2, 30.2, 12, 511);
        food.updateFood(foodData1);
    }
}