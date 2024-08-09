package com.recipesns.post.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String filePath;
    private String fileName;

    public Image(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
