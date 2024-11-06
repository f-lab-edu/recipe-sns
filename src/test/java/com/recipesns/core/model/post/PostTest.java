package com.recipesns.core.model.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    @DisplayName("좋아요시 likeCount가 1씩 증가한다")
    void increaseLikeCount() {
        // given
        Member member = createMember();
        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        List<Food> foods = List.of(food1, food2);
        List<Map<String, String>> postImages = createPostImages();
        Post post = Post.create(member, postImages, foods, "ssss");
        // when
        post.increaseLikeCount();
        post.increaseLikeCount();
        // then
        assertThat(post.getLikeCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("좋아요시 likeCount가 1씩 감소한다")
    void decreaseLikeCount() {
        // given
        Member member = createMember();
        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        List<Food> foods = List.of(food1, food2);
        List<Map<String, String>> postImages = createPostImages();
        Post post = Post.create(member, postImages, foods, "ssss");
        // when
        post.increaseLikeCount();
        post.increaseLikeCount();
        post.decreaseLikeCount();
        post.decreaseLikeCount();
        // then
        assertThat(post.getLikeCount()).isEqualTo(0);
    }

    private static List<Map<String, String>> createPostImages() {
        return List.of(Map.of("url", "dasda.png"), Map.of("url", "dasda.png"));
    }

    private static Member createMember() {
        return Member.builder()
                .username("rlagudwog")
                .password("asdasdasdasd123123")
                .nickname("nickname")
                .build();
    }

    private static Food createFood(String foodName, String foodCode) {
        return Food.builder()
                .foodName(foodName)
                .fat(12313)
                .protein(123123)
                .carbohydrate(123123)
                .foodCode(foodCode)
                .foodSize(1231)
                .calorie(12312)
                .build();
    }
}
