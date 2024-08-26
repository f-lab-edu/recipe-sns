package com.recipesns.repository.food;

import com.recipesns.core.model.food.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataJdbcFoodRepository extends CrudRepository<Food, Long> {
    Food findByFoodCode(String foodCode);
    List<Food> findAll(Pageable pageable);
    List<Food> findByFoodNameContaining(String foodName, Pageable pageable);
}
