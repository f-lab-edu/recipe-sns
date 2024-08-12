package com.recipesns.post.domain;

import com.recipesns.post.controller.dto.Food;
import com.recipesns.post.controller.dto.Image;
import com.recipesns.post.controller.dto.PostCreateRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    public Post from(PostCreateRequestDto dto) {
        return Post.builder()
                .memberId(dto.getMemberId())
                .content(dto.getContent())
                .images(postImageMapping(dto.getImages()))
                .foods(postFoodMapping(dto.getFoods()))
                .likeCount(0L)
                .build();
    }

    private static Set<PostFood> postFoodMapping(List<Food> foods) {
        return foods.stream()
                .map(food -> new PostFood(food.getFoodId()))
                .collect(Collectors.toSet());
    }

    private static PostImages postImageMapping(List<Image> images) {
        List<PostImage> postImages = images.stream()
                .map(image -> new PostImage(image.getFilePath(), image.getFileName()))
                .collect(Collectors.toList());
        return new PostImages(postImages);
    }
}
