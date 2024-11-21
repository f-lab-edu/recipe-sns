package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.service.member.request.MemberFollowServiceRequest;
import com.recipesns.web.exception.BusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class MemberFollowServiceTest {

    @Autowired
    private MemberFollowService memberFollowService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("팔로우를 중복으로하면 예외가 던져진다")
    void member_follow_duplicate() {
        // given
        Member member1 = memberRepository.save(createMember());
        Member member2 = memberRepository.save(createMember());

        MemberFollowServiceRequest request = MemberFollowServiceRequest.builder()
                .followingId(member2.getId())
                .followerId(member1.getId())
                .build();

        memberFollowService.follow(request);
        // when // then
        Assertions.assertThatThrownBy(() -> memberFollowService.follow(request))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("이미 팔로우중인 회원입니다");
    }

    private static Member createMember() {
        return Member.builder()
                .username("rlagudwog")
                .password("asdasdasdasd123123")
                .nickname("nickname")
                .build();
    }
}