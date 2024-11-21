package com.recipesns.core.service.food.provider.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Root {
    @JsonProperty("row")
    private List<FoodData> foodList;
}
