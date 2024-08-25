package com.recipesns.core.model.post.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipesns.core.model.post.PostImages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

import static com.recipesns.web.exception.SystemError.*;

@Slf4j
@ReadingConverter
@RequiredArgsConstructor
public class JsonToPostImagesConverter implements Converter<String, PostImages> {
    private final ObjectMapper objectMapper;

    @Override
    public PostImages convert(String source) {
        try {
            return objectMapper.readValue(source, PostImages.class);
        } catch (IOException e) {
            throw JSON_CONVERTER_ERROR.exception();
        }
    }
}
