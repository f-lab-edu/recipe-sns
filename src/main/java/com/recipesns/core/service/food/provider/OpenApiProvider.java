package com.recipesns.core.service.food.provider;
import com.recipesns.core.service.food.FoodProvider;
import com.recipesns.core.service.food.provider.responce.FoodData;
import com.recipesns.core.service.food.provider.responce.OpenApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OpenApiProvider implements FoodProvider {

    private static final String OPEN_API_URL = "http://openapi.foodsafetykorea.go.kr/api/06f5ad4e4ad84a83bad3/I2790/json/{startPage}/{endPage}/CHNG_DT={today}";

    private final RestClientService restClientService;

    public List<FoodData> getFoods(String today, Integer startPage, Integer endPage)  {

        OpenApiResponse response = getResponse(today, startPage, endPage);

        return response.getRoot().getFoodList();
    }

    private OpenApiResponse getResponse(String today,Integer startPage, Integer endPage) {
        return restClientService.create().get()
                .uri(OPEN_API_URL, startPage, endPage, today)
                .retrieve()
                .body(OpenApiResponse.class);
    }
}
