package com.recipesns.post.repository;

import com.recipesns.post.domain.Post;
import com.recipesns.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcPostRepository implements PostRepository {

    private final SpringDataJdbcPostRepository repository;

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return repository.findById(id);
    }
}
