package com.recipesns.post.domain.repository;

import com.recipesns.post.domain.PostLike;

public interface PostLikeRepository {
    PostLike save(PostLike postLike);

    void delete(PostLike postLike);

    PostLike findByPostIdAndMemberId(Long postId, Long memberId);
}
