package com.recipesns.core.service.post;

import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostMapper;
import com.recipesns.web.post.dto.PostCreateRequestDto;
import com.recipesns.core.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.recipesns.web.exception.BusinessError.*;

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
                .orElseThrow(POST_NOT_FOUND_ERROR::exception);

        post.increaseLikeCount();

        postRepository.save(post);
    }

    @Transactional
    public void unLikePost(Long postId, Long memberId) {
        postLikeService.unLikePost(postId, memberId);

        Post post = postRepository.findById(postId)
                .orElseThrow(POST_NOT_FOUND_ERROR::exception);

        post.decreaseLikeCount();

        postRepository.save(post);
    }
}