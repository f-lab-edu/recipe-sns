package com.recipesns.post.controller;

import com.recipesns.post.controller.dto.PostCreateRequestDto;
import com.recipesns.post.domain.Post;
import com.recipesns.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public Post create(@RequestBody PostCreateRequestDto dto) {
        return postService.createPost(dto);
    }
}
