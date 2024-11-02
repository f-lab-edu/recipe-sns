package com.recipesns.repository.post;

import com.recipesns.core.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
