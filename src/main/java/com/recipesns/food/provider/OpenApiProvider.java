package com.recipesns.food.provider;
import com.recipesns.food.provider.responce.FoodData;
import com.recipesns.food.provider.responce.OpenApiResponse;
import com.recipesns.food.service.FoodProvider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Component
public class OpenApiProvider implements FoodProvider {

    private static final String OPEN_API_URL = "http://openapi.foodsafetykorea.go.kr/api/06f5ad4e4ad84a83bad3/I2790/json/{startPage}/{endPage}/CHNG_DT={today}";

    private final RestClient restClient = RestClient.create();

    public List<FoodData> getFoods(String today, Integer startPage, Integer endPage)  {

        OpenApiResponse response = getResponse(today, startPage, endPage);

        return response.getRoot().getFoodList();
    }

    private OpenApiResponse getResponse(String today,Integer startPage, Integer endPage) {
        return restClient.get()
                .uri(OPEN_API_URL, startPage, endPage, today)
                .retrieve()
                .body(OpenApiResponse.class);
    }
}
