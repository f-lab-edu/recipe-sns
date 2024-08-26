package com.recipesns.repository.post;

import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.post.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcPostLikeRepository implements PostLikeRepository {

    private final SpringDataJdbcPostLikeRepository repository;

    @Override
    public PostLike save(PostLike postLike) {
        return repository.save(postLike);
    }

    @Override
    public void delete(PostLike postLike) {
         repository.delete(postLike);
    }

    @Override
    public Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId) {
        return repository.findByPostIdAndMemberId(postId, memberId);
    }
}
