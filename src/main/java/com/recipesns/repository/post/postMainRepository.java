package com.recipesns.repository.post;

import com.recipesns.core.model.post.Post;
import com.recipesns.core.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class postMainRepository implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Long save(Post post) {
        Post savedPost = jpaPostRepository.save(post);
        return savedPost.getId();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return jpaPostRepository.findById(id);
    }

    @Override
    public Page<Post> findPostsByFollowedMembers(Long memberId, Pageable pageable) {
        return jpaPostRepository.findPostsByFollowedMembers(memberId, pageable);
    }
}
