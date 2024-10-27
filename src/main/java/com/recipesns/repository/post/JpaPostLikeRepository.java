package com.recipesns.repository.post;

import com.recipesns.core.model.post.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
