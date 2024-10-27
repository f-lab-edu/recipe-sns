package com.recipesns.core.repository.post;

import com.recipesns.core.model.post.PostLike;

import java.util.Optional;

public interface PostLikeRepository {
    Long save(PostLike postLike);
    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
    Optional<PostLike> findById(Long id);
    Long deleteById(Long id);
}
