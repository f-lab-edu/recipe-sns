package com.recipesns.core.model.post;

import com.recipesns.core.model.BaseEntity;
import com.recipesns.core.model.food.Food;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_food_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Builder
    private PostFood(Post post, Food food) {
        this.post = post;
        this.food = food;
    }
}
