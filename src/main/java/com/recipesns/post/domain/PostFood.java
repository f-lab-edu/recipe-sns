package com.recipesns.post.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("POST_FOOD")
public class PostFood {
    @Id
    private Long id;
    @Column("FOOD_ID")
    private Long foodId;
    @Column("POST_ID")
    private Long postId;
    private LocalDateTime createdAt;

    public PostFood(Long foodId) {
        this.foodId = foodId;
        this.createdAt = LocalDateTime.now();
    }
}
