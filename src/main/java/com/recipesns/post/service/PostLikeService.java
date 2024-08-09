package com.recipesns.post.service;

import com.recipesns.post.domain.PostLike;
import com.recipesns.post.domain.PostLikeMapper;
import com.recipesns.post.domain.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository repository;
    private final PostLikeMapper postLikeMapper;

    public void likePost(Long postId, Long memberId) {
        PostLike postLike = repository.findByPostIdAndMemberId(postId, memberId);
        if (postLike != null) {
            throw new IllegalArgumentException("좋아요를 중복으로 할 수 없습니다");
        }
        repository.save(postLikeMapper.from(postId, memberId));
    }

    public void unLikePost(Long postId, Long memberId) {
        PostLike postLike = repository.findByPostIdAndMemberId(postId, memberId);
        if (postLike == null) {
            throw new IllegalArgumentException("좋아요 데이터를 찾을 수 없습니다");
        }
        repository.delete(postLike);
    }
}
