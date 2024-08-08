package com.recipesns.post.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.post.domain.PostImages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
public class PostImagesToJsonConverter implements Converter<PostImages, String> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(PostImages images) {
        try {
            return objectMapper.writeValueAsString(images);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not convert list of PostImage to JSON string", e);
        }
    }
}
