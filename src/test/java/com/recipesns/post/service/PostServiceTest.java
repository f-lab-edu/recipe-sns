package com.recipesns.post.service;

import com.recipesns.post.controller.dto.Food;
import com.recipesns.post.controller.dto.Image;
import com.recipesns.post.controller.dto.PostCreateRequestDto;
import com.recipesns.post.domain.Post;
import com.recipesns.post.domain.PostFood;
import com.recipesns.post.domain.PostMapper;
import com.recipesns.post.stub.MemoryPostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class PostServiceTest {

    private final PostMapper postMapper = new PostMapper();
    private final MemoryPostRepository postRepository = new MemoryPostRepository();
    private final PostService postService = new PostService(postRepository, postMapper);

    @AfterEach
    void afterEach() {
        postRepository.clearMemory();
    }

    @Test
    void createPost() {
        PostCreateRequestDto dto = PostCreateRequestDto.builder()
                .memberId(1L)
                .content("게시물 내용")
                .images(List.of(new Image("asda", "asd")))
                .foods(List.of(new Food(1L)))
                .build();
        Post post = postService.createPost(dto);
        Optional<Post> findPost = postRepository.findById(post.getId());
        assertThat(post.getId()).isEqualTo(findPost.get().getId());
    }
}