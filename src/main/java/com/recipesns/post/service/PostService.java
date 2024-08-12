package com.recipesns.post.service;

import com.recipesns.post.controller.dto.PostCreateRequestDto;
import com.recipesns.post.domain.*;
import com.recipesns.post.domain.repository.PostRepository;
import com.recipesns.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostLikeService postLikeService;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Transactional
    public Post createPost(PostCreateRequestDto dto) {
        return postRepository.save(postMapper.from(dto));
    }

    @Transactional
    public void likePost(Long postId, Long memberId) {
        postLikeService.likePost(postId, memberId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("게시물을 찾을 수 없습니다"));

        post.increaseLikeCount();

        postRepository.save(post);
    }

    @Transactional
    public void unLikePost(Long postId, Long memberId) {
        postLikeService.unLikePost(postId, memberId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("게시물을 찾을 수 없습니다"));

        post.decreaseLikeCount();

        postRepository.save(post);
    }
}
