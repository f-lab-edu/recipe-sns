package com.recipesns.repository.post;

import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.post.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostLikeMainRepository implements PostLikeRepository {

    private final JpaPostLikeRepository jpaPostLikeRepository;

    @Override
    public Long save(PostLike postLike) {
        jpaPostLikeRepository.save(postLike);
        return postLike.getId();
    }

    @Override
    public Optional<PostLike> findById(Long id) {
        return jpaPostLikeRepository.findById(id);
    }

    @Override
    public Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId) {
        return jpaPostLikeRepository.findByPostIdAndMemberId(postId, memberId);
    }

    @Override
    public Long deleteById(Long id) {
        jpaPostLikeRepository.deleteById(id);
        return id;
    }
}
