package com.recipesns.repository.post;

import com.recipesns.core.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
    Page<Post> findPostsByFollowedMembers(Long memberId, Pageable pageable);
}
