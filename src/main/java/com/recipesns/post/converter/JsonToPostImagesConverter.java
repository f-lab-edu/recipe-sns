package com.recipesns.post.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.post.domain.PostImages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

@Slf4j
@ReadingConverter
@RequiredArgsConstructor
public class JsonToPostImagesConverter implements Converter<byte[], PostImages> {
    private final ObjectMapper objectMapper;

    @Override
    public PostImages convert(byte[] source) {
        try {
            String jsonSource = objectMapper.readValue(source, String.class);
            return objectMapper.readValue(jsonSource, PostImages.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
