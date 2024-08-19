package com.recipesns.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostImage {
    private String filePath;
    private String fileName;

    public PostImage(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
