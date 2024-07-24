package com.recipesns.food.service;

import com.recipesns.food.FoodSearchCond;
import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import com.recipesns.food.provider.FoodProviderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class FoodServiceTest {
    @Autowired
    FoodRepository repository;

    FoodService foodService;

    @BeforeEach
    void beforeEach() {
        foodService = new FoodService(repository, new FoodProviderStub());
    }

    @Test
    @Transactional
    void update() {
        Food food1 = new Food("음식 이름1", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food food2 = new Food("음식 이름2", 140, "DS1235", 50.2, 30.2, 12, 511);
        Food food3 = new Food("음식 이름3", 140, "DS1236", 50.2, 30.2, 12, 511);
        Food savedFood1 = repository.save(food1);
        Food savedFood2 = repository.save(food2);
        Food savedFood3 = repository.save(food3);

        foodService.updateFood(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        Food findFood1 = repository.findById(savedFood1.getId());
        Food findFood2 = repository.findById(savedFood2.getId());
        Food findFood3 = repository.findById(savedFood3.getId());

        assertThat(findFood1.getFoodSize()).isEqualTo(141);
        assertThat(findFood2.getFoodSize()).isEqualTo(142);
        assertThat(findFood3.getFoodSize()).isEqualTo(143);
    }

    @Test
    @Transactional
    @DisplayName("page = 1, size = 2 , searchKey = 닭가슴살로 조회시 2개의 데이터를 리턴한다")
    void page() {
        Food food1 = new Food("닭가슴살 덮밥", 140, "DS1234", 50.2, 30.2, 12, 511);
        Food food2 = new Food("닭가슴살 스테이크", 140, "DS1235", 50.2, 30.2, 12, 511);
        Food food3 = new Food("닭가슴살", 140, "DS1236", 50.2, 30.2, 12, 511);
        Food food4 = new Food("스테이크 피자", 140, "DS1237", 50.2, 30.2, 12, 511);

        repository.save(food1);
        repository.save(food2);
        repository.save(food3);
        repository.save(food4);
        FoodSearchCond cond = new FoodSearchCond("닭가슴살", 1, 2);
        List<Food> foods = foodService.getFoods(cond);
        assertThat(foods.size()).isEqualTo(2);

    }
}