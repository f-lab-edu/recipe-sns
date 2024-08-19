package com.recipesns.domain.post.repository;

import com.recipesns.domain.post.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
}
