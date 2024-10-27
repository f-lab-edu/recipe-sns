package com.recipesns.core.service.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostLikeRepository;
import com.recipesns.core.repository.post.PostRepository;
import com.recipesns.core.service.post.request.PostLikeServiceRequest;
import com.recipesns.web.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class PostLikeServiceTest {

    @Autowired
    private PostLikeService postLikeService;

    @Autowired
    private PostLikeRepository postLikeRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    @DisplayName("좋아요를 중복으로하면 예외가 던져진다.")
    void duplicationTest() {
        // given
        Member member = memberRepository.save(createMember());
        System.out.println(member.getId());
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

        PostLikeServiceRequest request = PostLikeServiceRequest.builder()
                .memberId(member.getId())
                .postId(post.getId())
                .build();
        // when // then
        assertThatThrownBy(() -> postLikeService.postLike(request))
                .hasMessageContaining("좋아요를 중복으로 할 수 없습니다")
                .isInstanceOf(BusinessException.class);
    }

    @Test
    @DisplayName("회원이 아니면 예외가 던져진다.")
    void memberNotFoundTest() {
        // given
        Member member = memberRepository.save(createMember());
        System.out.println(member.getId());
        List<Map<String, String>> postImages = createPostImages();

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);

        List<Food> foods = List.of(food1, food2);
        Post post = createPost(member, postImages, foods);
        postRepository.save(post);

        PostLikeServiceRequest request = PostLikeServiceRequest.builder()
                .memberId(member.getId() + 1)
                .postId(post.getId())
                .build();
        // when // then
        assertThatThrownBy(() -> postLikeService.postLike(request))
                .hasMessageContaining("회원 정보를 찾을 수 없습니다.")
                .isInstanceOf(BusinessException.class);
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