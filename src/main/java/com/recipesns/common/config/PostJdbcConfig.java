package com.recipesns.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.domain.post.converter.JsonToPostImagesConverter;
import com.recipesns.domain.post.converter.PostImagesToJsonConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class PostJdbcConfig extends AbstractJdbcConfiguration {

    private final ObjectMapper objectMapper;

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
            new PostImagesToJsonConverter(objectMapper),
            new JsonToPostImagesConverter(objectMapper)
        ));
    }
}
