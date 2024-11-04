package com.recipesns.core.service.post.response;

import com.recipesns.core.model.post.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PostListResponse {

    private List<PostMemberResponse> posts;

    @Builder
    public PostListResponse(List<PostMemberResponse> posts) {
        this.posts = posts;
    }

    public static PostListResponse of(Page<Post> posts) {
        List<PostMemberResponse> postMemberResponses = posts.getContent().stream()
                .map(post -> PostMemberResponse.builder()
                        .postId(post.getId())
                        .likeCount(post.getLikeCount())
                        .content(post.getContent())
                        .images(post.getPostImages())
                        .member(MemberResponse.builder()
                                .nickname(post.getMember().getNickname())
                                .memberId(post.getMember().getId())
                                .build())
                        .build())
                .toList();
        return new PostListResponse(postMemberResponses);
    }

}
