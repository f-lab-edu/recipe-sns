package com.recipesns.post.controller;

import com.recipesns.post.controller.dto.PostCreateRequestDto;
import com.recipesns.post.domain.Post;
import com.recipesns.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{postId}/like")
    public void like(@PathVariable Long postId, @RequestParam Long memberId) {
        postService.likePost(postId, memberId);
    }

    @PostMapping("/{postId}/unlike")
    public void unLike(@PathVariable Long postId, @RequestParam Long memberId) {
        postService.unLikePost(postId, memberId);
    }
}
