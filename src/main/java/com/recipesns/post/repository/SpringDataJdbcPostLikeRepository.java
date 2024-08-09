package com.recipesns.post.repository;

import com.recipesns.post.domain.PostLike;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataJdbcPostLikeRepository extends CrudRepository<PostLike, Long> {
    PostLike findByPostIdAndMemberId(Long postId, Long memberId);
}
