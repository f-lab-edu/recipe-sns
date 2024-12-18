package com.recipesns.core.service.post;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostLikeRepository;
import com.recipesns.core.repository.post.PostRepository;
import com.recipesns.core.service.post.request.PostLikeServiceRequest;
import com.recipesns.core.service.post.response.PostLikeResponse;
import com.recipesns.web.exception.BusinessError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public PostLikeResponse postLike(PostLikeServiceRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(BusinessError.POST_MEMBER_NOT_FOUND_ERROR::exception);

        Post post = postRepository.findByIdForUpdate(request.getPostId())
                .orElseThrow(BusinessError.POST_NOT_FOUND_ERROR::exception);

        postLikeRepository.findByPostIdAndMemberId(post.getId(), member.getId())
                .ifPresent(postLike -> {
                    throw BusinessError.DUPLICATE_LIKE_ERROR.exception();
                });

        PostLike postLike = PostLike.create(post, member);
        postLikeRepository.save(postLike);
        post.increaseLikeCount();
        return PostLikeResponse.of(postLike);
    }

    @Transactional
    public PostLikeResponse postRemoveLike(PostLikeServiceRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(BusinessError.POST_MEMBER_NOT_FOUND_ERROR::exception);

        Post post = postRepository.findByIdForUpdate(request.getPostId())
                .orElseThrow(BusinessError.POST_NOT_FOUND_ERROR::exception);

        PostLike postLike = postLikeRepository.findByPostIdAndMemberId(post.getId(), member.getId())
                .orElseThrow(BusinessError.POST_LIKE_NOT_FOUND_ERROR::exception);

        postLikeRepository.deleteById(postLike.getId());
        post.decreaseLikeCount();
        return PostLikeResponse.of(postLike);
    }
}
