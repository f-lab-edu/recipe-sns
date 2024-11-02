package com.recipesns.core.repository.post;

import com.recipesns.core.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostRepository {
    Long save(Post post);

    Optional<Post> findById(Long id);

    Page<Post> findPostsByFollowedMembers(Long memberId, Pageable pageable);
}
