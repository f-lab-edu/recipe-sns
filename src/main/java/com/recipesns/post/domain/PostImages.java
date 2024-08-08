package com.recipesns.post.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostImages {
    List<PostImage> images;

    public PostImages(List<PostImage> images) {
        this.images = images;
    }
}
