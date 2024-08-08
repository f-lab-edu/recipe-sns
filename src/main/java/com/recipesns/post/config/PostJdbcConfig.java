package com.recipesns.post.config;

import com.recipesns.post.converter.JsonToPostImagesConverter;
import com.recipesns.post.converter.PostImagesToJsonConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;

@Configuration
public class PostJdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
            new PostImagesToJsonConverter(),
            new JsonToPostImagesConverter()
        ));
    }
}
