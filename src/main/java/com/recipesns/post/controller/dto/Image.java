package com.recipesns.post.controller.dto;

import lombok.Getter;

@Getter
public class Image {
    private String filePath;
    private String fileName;

    public Image(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
