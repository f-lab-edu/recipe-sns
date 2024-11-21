package com.recipesns.repository.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostLikeRepository;
import com.recipesns.core.repository.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class PostLikeMainRepositoryTest {

    @Autowired
    private PostLikeRepository postLikeRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;

    @Test
    @DisplayName("게시물 좋아요를 할 수 있다.")
    @Rollback(value = false)
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
        postRepository.save(post);

        // when
        PostLike postLike = PostLike.builder()
                .member(member)
                .post(post)
                .build();
        postLikeRepository.save(postLike);

        // then
        assertThat(postLike.getId()).isNotNull();
        assertThat(postLike.getMember().getId()).isEqualTo(member.getId());
        assertThat(postLike.getPost().getId()).isEqualTo(post.getId());
        assertThat(postLike.getPost().getContent()).isEqualTo("내용");
    }

    @Test
    @DisplayName("게시물 좋아요를 삭제 할 수 있다.")
    @Rollback(value = false)
    void delete() {
        // given
        Member member = memberRepository.save(createMember());

        List<Map<String, String>> postImages = createPostImages();

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);

        List<Food> foods = List.of(food1, food2);
        Post post = createPost(member, postImages, foods);
        postRepository.save(post);

        PostLike postLike = PostLike.builder()
                .member(member)
                .post(post)
                .build();
        postLikeRepository.save(postLike);

        // when
        Long postLikeId = postLikeRepository.deleteById(postLike.getId());
        Optional<PostLike> findPostLike = postLikeRepository.findById(postLikeId);
        // then
        assertThat(postLikeId).isEqualTo(postLike.getId());
        assertThat(findPostLike).isEmpty();
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