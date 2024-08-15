package com.recipesns.post.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Table("POST")
@Getter
public class Post {

    @Id
    private Long id;
    private Long memberId;
    private Long likeCount;
    private String content;
    private PostImages images;
    @MappedCollection(idColumn = "POST_ID")
    private Set<PostFood> foods;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Post(Long memberId, Long likeCount, String content, PostImages images, Set<PostFood> foods) {
        this.memberId = memberId;
        this.likeCount = likeCount;
        this.images = images;
        this.content = content;
        this.foods = foods;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void increaseLikeCount() {
        this.likeCount = this.likeCount + 1;
    }

    public void decreaseLikeCount() {
        this.likeCount = this.likeCount - 1;
    }

    // 테스트용
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(memberId, post.memberId) && Objects.equals(content, post.content) && Objects.equals(images, post.images) && Objects.equals(createdAt, post.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, content, images, createdAt);
    }
}
