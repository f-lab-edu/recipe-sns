package com.recipesns.repository.food;

import com.recipesns.core.model.food.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaFoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByFoodNameContaining(String foodName, Pageable pageable);
    List<Food> findAllByFoodCodeIn(List<String> foodCodes);
    List<Food> findAllByIdIn(List<Long> ids);
}
