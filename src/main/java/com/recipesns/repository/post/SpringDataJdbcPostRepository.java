package com.recipesns.repository.post;

import com.recipesns.domain.post.Post;
import org.springframework.data.relational.core.sql.LockMode;
import org.springframework.data.relational.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataJdbcPostRepository extends CrudRepository<Post, Long> {

    @Override
    @Lock(LockMode.PESSIMISTIC_WRITE)
    Optional<Post> findById(Long id);
}
