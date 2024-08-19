package com.recipesns.web.post.dto;

import lombok.Getter;

@Getter
public class ImageRequest {
    private String filePath;
    private String fileName;

    public ImageRequest(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
