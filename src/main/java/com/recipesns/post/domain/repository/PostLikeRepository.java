package com.recipesns.post.domain.repository;

import com.recipesns.post.domain.PostLike;

import java.util.Optional;

public interface PostLikeRepository {
    PostLike save(PostLike postLike);

    void delete(PostLike postLike);

    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
