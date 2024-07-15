package com.recipesns.food.repository;

import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcFoodRepository implements FoodRepository {
    private final NamedParameterJdbcTemplate template;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcFoodRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("foods")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Food save(Food food) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(food);
        Number key = jdbcInsert.executeAndReturnKey(param);
        food.setId(key.longValue());
        return food;
    }

    @Override
    public Food findById(Long id) {
        return null;
    }

    @Override
    public Food update(Long id, Food food) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
