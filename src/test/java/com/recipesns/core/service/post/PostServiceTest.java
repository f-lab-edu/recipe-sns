package com.recipesns.core.service.post;

import com.recipesns.web.post.dto.FoodRequest;
import com.recipesns.web.post.dto.ImageRequest;
import com.recipesns.web.post.dto.PostCreateRequestDto;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostLikeMapper;
import com.recipesns.core.model.post.PostMapper;
import com.recipesns.repository.post.stub.MemoryPostLikeRepository;
import com.recipesns.repository.post.stub.MemoryPostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class PostServiceTest {

    private final PostLikeMapper postLikeMapper = new PostLikeMapper();
    private final MemoryPostLikeRepository postLikeRepository = new MemoryPostLikeRepository();
    private final PostLikeService postLikeService = new PostLikeService(postLikeRepository, postLikeMapper);
    private final PostMapper postMapper = new PostMapper();
    private final MemoryPostRepository postRepository = new MemoryPostRepository();
    private final PostService postService = new PostService(postLikeService, postRepository, postMapper);

    @AfterEach
    void afterEach() {
        postRepository.clearMemory();
    }

    @Test
    void createPost() {
        PostCreateRequestDto dto = PostCreateRequestDto.builder()
                .memberId(1L)
                .content("게시물 내용")
                .images(List.of(new ImageRequest("asda", "asd")))
                .foods(List.of(new FoodRequest(1L)))
                .build();
        Post post = postService.createPost(dto);
        Optional<Post> findPost = postRepository.findById(post.getId());
        assertThat(post.getId()).isEqualTo(findPost.get().getId());
    }
}