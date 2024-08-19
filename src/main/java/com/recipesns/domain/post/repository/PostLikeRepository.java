package com.recipesns.domain.post.repository;

import com.recipesns.domain.post.PostLike;

import java.util.Optional;

public interface PostLikeRepository {
    PostLike save(PostLike postLike);

    void delete(PostLike postLike);

    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
