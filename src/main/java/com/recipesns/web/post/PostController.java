package com.recipesns.web.post;

import com.recipesns.core.model.member.Member;
import com.recipesns.web.argumentresolver.Login;
import com.recipesns.web.response.ApiResponse;
import com.recipesns.web.post.dto.PostCreateRequestDto;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.service.post.PostService;
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
    public ApiResponse<Post> create(@RequestBody PostCreateRequestDto dto) {
        return ApiResponse.success(postService.createPost(dto));
    }

    @PostMapping("/{postId}/like")
    public ApiResponse<Void> like(@Login Member loginMember, @PathVariable Long postId) {
        postService.likePost(postId, loginMember.getId());
        return ApiResponse.success();
    }

    @PostMapping("/{postId}/unlike")
    public ApiResponse<Void> unLike(@Login Member loginMember, @PathVariable Long postId) {
        postService.unLikePost(postId, loginMember.getId());
        return ApiResponse.success();
    }
}
