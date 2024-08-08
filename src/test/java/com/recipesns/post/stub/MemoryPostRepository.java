package com.recipesns.post.stub;

import com.recipesns.post.domain.Post;
import com.recipesns.post.domain.PostRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryPostRepository implements PostRepository {

    private static Map<Long, Post> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Post save(Post post) {
        sequence++;
        post.setId(sequence);
        store.put(sequence, post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void clearMemory() {
        sequence = 0L;
        store.clear();
    }
}