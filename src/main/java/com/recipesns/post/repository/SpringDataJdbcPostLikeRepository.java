package com.recipesns.post.repository;

import com.recipesns.post.domain.PostLike;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataJdbcPostLikeRepository extends CrudRepository<PostLike, Long> {
    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
