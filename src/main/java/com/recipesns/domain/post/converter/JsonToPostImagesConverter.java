package com.recipesns.domain.post.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.domain.post.PostImages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

import static com.recipesns.common.exception.SystemError.*;

@Slf4j
@ReadingConverter
@RequiredArgsConstructor
public class JsonToPostImagesConverter implements Converter<String, PostImages> {
    private final ObjectMapper objectMapper;

    @Override
    public PostImages convert(String source) {
        try {
//            String jsonSource = objectMapper.readValue(source, String.class);
            return objectMapper.readValue(source, PostImages.class);
        } catch (IOException e) {
            throw JSON_CONVERTER_ERROR.exception();
        }
    }
}
