package com.recipesns.domain.post;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("POST_LIKE")
public class PostLike {
    @Id
    private Long id;
    @Column("MEMBER_ID")
    private Long memberId;
    @Column("POST_ID")
    private Long postId;
    private LocalDateTime createdAt;

    @Builder
    public PostLike(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
        this.createdAt = LocalDateTime.now();
    }

    //테스트용
    public void setId(Long id) {
        this.id = id;
    }
}
