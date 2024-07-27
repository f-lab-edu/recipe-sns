package com.recipesns.food.repository;

import com.recipesns.food.provider.responce.FoodData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcFoodBulkUpdateRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcFoodBulkUpdateRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int[] bulkUpdate(List<FoodData> foodList) {
        String sql = "UPDATE foods SET food_name = ?, food_size = ?, carbohydrate = ?, protein = ?, calorie = ?, fat = ? WHERE food_code = ?";

        List<Object[]> batch = foodList.stream()
                .map(food -> new Object[]{food.getFoodName(), food.getFoodSize(), food.getCarbohydrate(), food.getProtein(), food.getCalorie(), food.getFat(), food.getFoodCode()})
                .toList();
        return jdbcTemplate.batchUpdate(sql, batch);
    }
}
