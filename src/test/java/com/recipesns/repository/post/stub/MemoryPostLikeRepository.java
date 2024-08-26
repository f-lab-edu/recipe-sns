package com.recipesns.repository.post.stub;

import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.post.PostLikeRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryPostLikeRepository implements PostLikeRepository {

    private static Map<Long, PostLike> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public PostLike save(PostLike postLike) {
        sequence++;
        postLike.setId(sequence);
        store.put(sequence, postLike);
        return postLike;
    }

    @Override
    public void delete(PostLike postLike) {
        store.remove(postLike.getId());
    }

    @Override
    public Optional<PostLike> findByPostIdAndMemberId(Long postId, Long memberId) {
        for (PostLike postLike : store.values()) {
            if (postLike.getPostId().equals(postId) && postLike.getMemberId().equals(memberId)) {
                return Optional.of(postLike);
            }
        }
        return Optional.empty();
    }

    public void clearMemory() {
        sequence = 0L;
        store.clear();
    }
}
