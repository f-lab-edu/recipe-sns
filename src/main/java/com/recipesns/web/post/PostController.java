package com.recipesns.web.post;

import com.recipesns.core.service.post.PostLikeService;
import com.recipesns.core.service.post.PostService;
import com.recipesns.core.service.post.request.PostLikeServiceRequest;
import com.recipesns.core.service.post.request.PostListServiceRequest;
import com.recipesns.core.service.post.request.PostServiceRequest;
import com.recipesns.core.service.post.response.PostLikeResponse;
import com.recipesns.core.service.post.response.PostListResponse;
import com.recipesns.core.service.post.response.PostResponse;
import com.recipesns.web.argumentresolver.Login;
import com.recipesns.web.post.request.PostCreateRequest;
import com.recipesns.web.post.request.PostLikeCreateRequest;
import com.recipesns.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostLikeService postLikeService;

    @GetMapping
    public ApiResponse<PostListResponse> getPost(@Login Long memberId, Pageable pageable) {
        return ApiResponse.success(postService.getPost(PostListServiceRequest.of(memberId, pageable.getPageNumber(), pageable.getPageSize())));
    }

    @PostMapping
    public ApiResponse<PostResponse> createPost(@Login Long memberId, @RequestBody PostCreateRequest request) {
        return ApiResponse.success(postService.createPost(PostServiceRequest.of(request.getContent(), memberId, request.getFoods(), request.getPostImages())));
    }

    @PostMapping("/like")
    public ApiResponse<PostLikeResponse> createPostLike(@Login Long memberId, @RequestBody PostLikeCreateRequest request) {
        return ApiResponse.success(postLikeService.postLike(PostLikeServiceRequest.of(request.getPostId(), memberId)));
    }

    @PostMapping("/remove_like")
    public ApiResponse<PostLikeResponse> removePostLike(@Login Long memberId, @RequestBody PostLikeCreateRequest request) {
        return ApiResponse.success(postLikeService.postRemoveLike(PostLikeServiceRequest.of(request.getPostId(), memberId)));
    }
}
