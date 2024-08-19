package com.recipesns.service.post;

import com.recipesns.domain.post.PostLike;
import com.recipesns.domain.post.PostLikeMapper;
import com.recipesns.domain.post.repository.PostLikeRepository;
import com.recipesns.service.post.exception.DuplicateLikeException;
import com.recipesns.service.post.exception.PostLikeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository repository;
    private final PostLikeMapper postLikeMapper;

    public void likePost(Long postId, Long memberId) {

        repository.findByPostIdAndMemberId(postId, memberId).ifPresent(postLike ->  {
            throw new DuplicateLikeException("좋아요를 중복으로 할 수 없습니다");
        });

        repository.save(postLikeMapper.from(postId, memberId));
    }

    public void unLikePost(Long postId, Long memberId) {
        PostLike postLike = repository.findByPostIdAndMemberId(postId, memberId)
                .orElseThrow(() -> new PostLikeNotFoundException("좋아요 데이터를 찾을 수 없습니다"));

        repository.delete(postLike);
    }
}
