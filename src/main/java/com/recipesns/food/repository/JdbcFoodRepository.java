package com.recipesns.food.repository;

import com.recipesns.food.domain.Food;
import com.recipesns.food.domain.FoodRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
        String sql = "select * from foods where id = :id";
        Map<String, Object> param = Map.of("id", id);
        return template.queryForObject(sql, param, foodRowMapper());
    }

    @Override
    public void update(Food food) {
        String sql = "update foods set " +
                "food_name=:foodName, " +
                "food_size=:foodSize, " +
                "carbohydrate=:carbohydrate, " +
                "protein=:protein, " +
                "fat=:fat, " +
                "calorie=:calorie " +
                "where food_code=:foodCode";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("foodName", food.getFoodName())
                .addValue("foodSize", food.getFoodSize())
                .addValue("carbohydrate", food.getCarbohydrate())
                .addValue("protein", food.getProtein())
                .addValue("fat", food.getFat())
                .addValue("calorie", food.getCalorie())
                .addValue("foodCode", food.getFoodCode());
        template.update(sql, param);
    }

    private RowMapper<Food> foodRowMapper() {
        return new RowMapper<Food>() {
            @Override
            public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
                Food food = new Food(
                        rs.getString("food_name"),
                        rs.getInt("food_size"),
                        rs.getString("food_code"),
                        rs.getDouble("carbohydrate"),
                        rs.getDouble("protein"),
                        rs.getDouble("fat"),
                        rs.getDouble("calorie")
                );
                food.setId(rs.getLong("id"));
                return food;
            }
        };
    }
}
