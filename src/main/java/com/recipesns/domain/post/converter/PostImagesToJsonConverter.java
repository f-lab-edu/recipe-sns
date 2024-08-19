package com.recipesns.domain.post.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.domain.post.converter.exception.JsonConversionException;
import com.recipesns.domain.post.PostImages;
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
            throw new JsonConversionException("이미지 리스트를 JSON 문자열로 변환할 수 없습니다", e);
        }
    }
}
