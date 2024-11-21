package com.recipesns.repository.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberFollow;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberFollowRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class PostMainRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberFollowRepository memberFollowRepository;
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

    @Test
    @DisplayName("자신이 팔로우한 회원의 게시물을 조회할 수 있다.")
    void findPostsByFollowedMembers() {
        // given
        Member member1 = createMember();
        Member member2 = createMember();
        Member member3 = createMember();

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        MemberFollow memberFollow1 = MemberFollow.builder()
                .follower(member1)
                .following(member2)
                .build();
        MemberFollow memberFollow2 = MemberFollow.builder()
                .follower(member1)
                .following(member3)
                .build();

        memberFollowRepository.save(memberFollow1);
        memberFollowRepository.save(memberFollow2);
        List<Map<String, String>> postImages = createPostImages();

        Food food1 = createFood("음식이름1", "AS234");
        Food food2 = createFood("음식이름2", "AS235");
        foodRepository.save(food1);
        foodRepository.save(food2);

        List<Food> foods = List.of(food1, food2);

        Post post1 = createPost(member1, postImages, foods);
        Post post2 = createPost(member2, postImages, foods);
        Post post3 = createPost(member3, postImages, foods);
        Post post4 = createPost(member1, postImages, foods);
        Post post5 = createPost(member2, postImages, foods);
        Post post6 = createPost(member3, postImages, foods);
        Post post7 = createPost(member3, postImages, foods);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
        postRepository.save(post7);
        PageRequest pageRequest = PageRequest.of(0, 2);
        // when
        Page<Post> posts = postRepository.findPostsByFollowedMembers(member1.getId(), pageRequest);
        // then
        assertThat(posts.getContent()).hasSize(2);
        assertThat(posts.getTotalPages()).isEqualTo(3);
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