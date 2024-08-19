package com.recipesns.service.food.provider.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OpenApiResponse {
    @JsonProperty("I2790")
    private Root root;
}
