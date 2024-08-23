package com.recipesns.service.post;

import com.recipesns.domain.post.PostLike;
import com.recipesns.domain.post.PostLikeMapper;
import com.recipesns.domain.post.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.recipesns.common.exception.BusinessError.*;

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
