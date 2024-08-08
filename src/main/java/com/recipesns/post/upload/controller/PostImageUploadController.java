package com.recipesns.post.upload.controller;

import com.recipesns.post.upload.dto.request.PostImageFileRequest;
import com.recipesns.post.upload.dto.response.PostImageFileResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class PostImageUploadController {

    @PostMapping("/post/upload")
    public PostImageFileResponse saveFile(@ModelAttribute PostImageFileRequest request) throws IOException {
        MultipartFile file = request.getFile();
        String fullPath = "/Users/kimbro/Desktop/" + UUID.randomUUID().toString().substring(0, 8) + file.getOriginalFilename();
        if (!file.isEmpty()) {
            file.transferTo(new File(fullPath));
        }
        return new PostImageFileResponse(file.getOriginalFilename(), fullPath);
    }
}
