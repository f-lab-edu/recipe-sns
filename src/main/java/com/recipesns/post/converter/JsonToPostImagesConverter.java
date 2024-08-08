package com.recipesns.post.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.post.domain.PostImages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@Slf4j
@ReadingConverter
public class JsonToPostImagesConverter implements Converter<String, PostImages> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PostImages convert(String source) {
        log.info("convert json to post images");
        try {
            return objectMapper.readValue(source, PostImages.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
