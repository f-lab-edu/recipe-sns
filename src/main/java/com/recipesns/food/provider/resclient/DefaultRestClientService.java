package com.recipesns.food.provider.resclient;

import com.recipesns.food.provider.RestClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DefaultRestClientService implements RestClientService {

    private final RestClient restClient = RestClient.create();

    @Override
    public RestClient create() {
        return restClient;
    }
}
