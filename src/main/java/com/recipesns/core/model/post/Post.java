package com.recipesns.core.model.post;

import com.recipesns.core.model.BaseEntity;
import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jakarta.persistence.FetchType.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Type(JsonType.class)
    @Column(name = "post_images", columnDefinition = "longtext")
    private List<Map<String, String>> postImages;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostFood> postFoods = new ArrayList<>();

    private String content;

    @Builder
    private Post(Member member, List<Map<String, String>> postImages, List<Food> foods, String content) {
        this.member = member;
        this.postImages = postImages;
        this.postFoods = foods.stream()
                .map(food -> PostFood.builder()
                        .post(this)
                        .food(food)
                        .build()
                )
                .toList();
        this.content = content;
    }

    public static Post create(Member member, List<Map<String, String>> postImages, List<Food> foods, String content) {
        return new Post(member, postImages, foods, content);
    }

}
