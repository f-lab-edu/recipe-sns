package com.recipesns.post.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table("POST")
public class Post {

    @Id
    private Long id;
    private Long memberId;
    private String content;
    private PostImages images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(Long memberId, String content, PostImages images) {
        this.memberId = memberId;
        this.images = images;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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
