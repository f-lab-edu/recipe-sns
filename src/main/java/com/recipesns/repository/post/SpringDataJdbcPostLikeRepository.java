package com.recipesns.repository.post;

import com.recipesns.core.model.post.PostLike;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataJdbcPostLikeRepository extends CrudRepository<PostLike, Long> {
    Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId);
}
