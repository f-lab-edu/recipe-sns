package com.recipesns.post.domain.repository;

import com.recipesns.post.domain.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
}
