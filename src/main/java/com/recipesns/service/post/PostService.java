package com.recipesns.service.post;

import com.recipesns.common.exception.BusinessError;
import com.recipesns.common.exception.BusinessException;
import com.recipesns.domain.post.Post;
import com.recipesns.domain.post.PostMapper;
import com.recipesns.web.post.dto.PostCreateRequestDto;
import com.recipesns.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostLikeService postLikeService;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Transactional
    public Post createPost(PostCreateRequestDto dto) {
        return postRepository.save(postMapper.from(dto));
    }

    @Transactional
    public void likePost(Long postId, Long memberId) {
        postLikeService.likePost(postId, memberId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BusinessException(BusinessError.POST_NOT_FOUND_ERROR.getCode(), BusinessError.POST_NOT_FOUND_ERROR.getMessage()));

        post.increaseLikeCount();

        postRepository.save(post);
    }

    @Transactional
    public void unLikePost(Long postId, Long memberId) {
        postLikeService.unLikePost(postId, memberId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BusinessException(BusinessError.POST_NOT_FOUND_ERROR.getCode(), BusinessError.POST_NOT_FOUND_ERROR.getMessage()));

        post.decreaseLikeCount();

        postRepository.save(post);
    }
}
