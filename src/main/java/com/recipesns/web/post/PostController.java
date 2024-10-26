package com.recipesns.web.post;

import com.recipesns.core.service.post.PostService;
import com.recipesns.core.service.post.request.PostServiceRequest;
import com.recipesns.core.service.post.response.PostResponse;
import com.recipesns.web.argumentresolver.Login;
import com.recipesns.web.post.request.PostCreateRequest;
import com.recipesns.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ApiResponse<PostResponse> createPost(@Login Long memberId, @RequestBody PostCreateRequest request) {
        return ApiResponse.success(postService.createPost(PostServiceRequest.of(request.getContent(), memberId, request.getFoods(), request.getPostImages())));
    }
}
