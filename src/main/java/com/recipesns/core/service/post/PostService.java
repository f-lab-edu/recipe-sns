package com.recipesns.core.service.post;

import com.recipesns.core.model.food.Food;
import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.repository.food.FoodRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.repository.post.PostRepository;
import com.recipesns.core.service.post.request.PostServiceRequest;
import com.recipesns.core.service.post.response.PostResponse;
import com.recipesns.web.exception.BusinessError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final FoodRepository foodRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public PostResponse createPost(PostServiceRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(BusinessError.MEMBER_NOT_FOUND_ERROR::exception);

        List<Food> foods = foodRepository.findAllByIdIn(request.getFoods());

        Post post = Post.create(member, request.getPostImages(), foods, request.getContent());

        postRepository.save(post);

        return PostResponse.of(post);
    }
}

