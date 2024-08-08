package com.recipesns.post.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.post.domain.PostImages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
@RequiredArgsConstructor
public class PostImagesToJsonConverter implements Converter<PostImages, String> {
    private final ObjectMapper objectMapper;

    @Override
    public String convert(PostImages images) {
        try {
            return objectMapper.writeValueAsString(images);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not convert list of PostImage to JSON string", e);
        }
    }
}
