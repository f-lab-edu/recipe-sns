package com.recipesns.core.service.post.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class PostMemberResponse {
    private Long postId;
    private String content;
    private Long likeCount;
    private List<Map<String, String>> images;
    private MemberResponse member;

    @Builder
    public PostMemberResponse(Long postId, String content, Long likeCount, List<Map<String, String>> images, MemberResponse member) {
        this.postId = postId;
        this.content = content;
        this.likeCount = likeCount;
        this.images = images;
        this.member = member;
    }
}
