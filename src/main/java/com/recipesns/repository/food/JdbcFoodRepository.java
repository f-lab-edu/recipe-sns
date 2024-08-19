package com.recipesns.repository.food;

import com.recipesns.web.food.dto.FoodSearchRequestDto;
import com.recipesns.domain.food.Food;
import com.recipesns.domain.food.FoodRepository;
import com.recipesns.service.food.provider.responce.FoodData;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcFoodRepository implements FoodRepository {

    private final SpringDataJdbcFoodRepository repository;
    private final JdbcTemplate jdbcTemplate;

    public JdbcFoodRepository(SpringDataJdbcFoodRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public Food findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Food> findAll(FoodSearchRequestDto cond) {
        String foodName = cond.getFoodName();
        Integer page = cond.getPage();
        Integer size = cond.getSize();
        PageRequest pageable = PageRequest.of(page - 1, size);

        if (StringUtils.hasText(foodName)) {
            return repository.findByFoodNameContaining(foodName, pageable);
        }

        return repository.findAll(pageable);
    }

    @Override
    public Integer bulkUpdate(List<FoodData> foodList) {
        String sql = "UPDATE food SET food_name = ?, food_size = ?, carbohydrate = ?, protein = ?, calorie = ?, fat = ? WHERE food_code = ?";

        List<Object[]> batch = foodList.stream()
                .map(food -> new Object[]{food.getFoodName(), food.getFoodSize(), food.getCarbohydrate(), food.getProtein(), food.getCalorie(), food.getFat(), food.getFoodCode()})
                .toList();
        jdbcTemplate.batchUpdate(sql, batch);
        return foodList.size();
    }
}
