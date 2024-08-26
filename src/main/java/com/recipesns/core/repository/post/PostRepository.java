package com.recipesns.core.repository.post;

import com.recipesns.core.model.post.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
}
