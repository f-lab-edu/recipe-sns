package com.recipesns.food.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.food.domain.Food;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodProvider {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Food> getFoods(String today) throws JsonProcessingException {

        String body = getBody(today);
        List<Food> foodList = new ArrayList<>();

        JsonNode rootNode = objectMapper.readTree(body);
        int totalCount = rootNode.path("I2790").path("total_count").asInt();

        if (totalCount != 0) {
            extractFoodData(rootNode, foodList);
        }

        return foodList;
    }

    private void extractFoodData(JsonNode rootNode, List<Food> foodList) {
        JsonNode rows = rootNode.path("I2790").path("row");

        for (JsonNode row : rows) {
            String foodName = row.path("DESC_KOR").asText();
            int foodSize = row.path("SERVING_SIZE").asInt();
            String foodCode = row.path("FOOD_CD").asText();
            double carbohydrate = row.path("NUTR_CONT2").asDouble(0.0);
            double protein = row.path("NUTR_CONT3").asDouble(0.0);
            double calorie = row.path("NUTR_CONT1").asDouble(0.0);
            double fat = row.path("NUTR_CONT4").asDouble(0.0);

            Food food = new Food(foodName, foodSize, foodCode, carbohydrate, protein, fat, calorie);
            foodList.add(food);
        }
    }

    private String getBody(String today) {
        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri("http://openapi.foodsafetykorea.go.kr/api/06f5ad4e4ad84a83bad3/I2790/json/1/1000/CHNG_DT=" + today)
                .retrieve()
                .body(String.class);
    }
}
