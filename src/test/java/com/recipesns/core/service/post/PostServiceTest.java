package com.recipesns.core.service.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.service.post.request.PostServiceRequest;
import com.recipesns.core.service.post.response.PostResponse;
import com.recipesns.web.exception.BusinessException;
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
class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;


    @Test
    @DisplayName("게시물 생성시 member 조회시 null이 리턴되면 예외가 던져진다")
    void findMemberException() {
        // given
        Member member = createMember();
        memberRepository.save(member);

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);
        List<Long> foods = List.of(food1.getId(), food2.getId());

        PostServiceRequest request = PostServiceRequest.builder()
                .memberId(member.getId() + 1L)
                .postImages(createPostImages())
                .foods(foods)
                .content("게시물 내용")
                .build();

        // when // then
        assertThatThrownBy(() -> postService.createPost(request)).isInstanceOf(BusinessException.class);
    }

    @Test
    @DisplayName("음식, 회원번호, 이미지를 받아 게시물을 생성한다.")
    void save() {
        // given
        Member member = createMember();
        memberRepository.save(member);

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);
        List<Long> foods = List.of(food1.getId(), food2.getId());

        PostServiceRequest request = PostServiceRequest.builder()
                .memberId(member.getId())
                .postImages(createPostImages())
                .foods(foods)
                .content("게시물 내용")
                .build();

        // when
        PostResponse postResponse = postService.createPost(request);

        // then
        assertThat(postResponse.getId()).isNotNull();
        assertThat(postResponse.getPostImages()).hasSize(2);
        assertThat(postResponse.getContent()).isEqualTo("게시물 내용");
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