package com.recipesns.repository.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class PostMainRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("게시물을 저장할 수 있다")
    void save() {
        // given

        Member member = memberRepository.save(createMember());

        List<Map<String, String>> postImages = createPostImages();

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);

        List<Food> foods = List.of(food1, food2);
        Post post = createPost(member, postImages, foods);
        // when
        Long id = postRepository.save(post);

        Post findPost = postRepository.findById(id).get();
        // then
        assertThat(findPost.getPostFoods()).hasSize(2);
        assertThat(findPost.getContent()).isEqualTo("내용");
    }

    @Test
    @DisplayName("저장된 게시물을 id값으로 조회할 수 있다.")
    void findById() {
        Member member = memberRepository.save(createMember());

        List<Map<String, String>> postImages = createPostImages();

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);

        List<Food> foods = List.of(food1, food2);
        Post post = createPost(member, postImages, foods);

        Long id = postRepository.save(post);
        // when
        Post findPost = postRepository.findById(id).get();
        // then
        assertThat(findPost.getPostFoods()).hasSize(2);
        assertThat(findPost.getContent()).isEqualTo("내용");
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

    private static Post createPost(Member member, List<Map<String, String>> postImages, List<Food> foods) {
        return Post.builder()
                .member(member)
                .postImages(postImages)
                .foods(foods)
                .content("내용")
                .build();
    }
}