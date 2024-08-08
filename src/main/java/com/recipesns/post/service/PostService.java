package com.recipesns.post.service;

import com.recipesns.post.controller.dto.PostCreateRequestDto;
import com.recipesns.post.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Transactional
    public Post createPost(PostCreateRequestDto dto) {
        return postRepository.save(postMapper.from(dto));
    }
}
