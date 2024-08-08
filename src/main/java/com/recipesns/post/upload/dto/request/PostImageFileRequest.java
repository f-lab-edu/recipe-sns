package com.recipesns.post.upload.dto.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostImageFileRequest {
    private MultipartFile file;

    public PostImageFileRequest(MultipartFile file) {
        this.file = file;
    }
}
