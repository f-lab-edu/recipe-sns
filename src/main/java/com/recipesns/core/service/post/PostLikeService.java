package com.recipesns.core.service.post;

import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.model.post.PostLikeMapper;
import com.recipesns.core.repository.post.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.recipesns.web.exception.BusinessError.*;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository repository;
    private final PostLikeMapper postLikeMapper;

    public void likePost(Long postId, Long memberId) {

        repository.findByPostIdAndMemberId(postId, memberId).ifPresent(postLike ->  {
            throw DUPLICATE_LIKE_ERROR.exception();
        });

        repository.save(postLikeMapper.from(postId, memberId));
    }

    public void unLikePost(Long postId, Long memberId) {
        PostLike postLike = repository.findByPostIdAndMemberId(postId, memberId)
                .orElseThrow(POST_LIKE_NOT_FOUND_ERROR::exception);

        repository.delete(postLike);
    }
}
