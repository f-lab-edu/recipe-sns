package com.recipesns.post.upload.dto.response;

import lombok.Getter;

@Getter
public class PostImageFileResponse {
    private String fileName;
    private String filePath;

    public PostImageFileResponse(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
