package com.recipesns.core.repository.post;

import com.recipesns.core.model.post.PostLike;

import java.util.Optional;

public interface PostLikeRepository {
    PostLike save(PostLike postLike);

    void delete(PostLike postLike);

    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
