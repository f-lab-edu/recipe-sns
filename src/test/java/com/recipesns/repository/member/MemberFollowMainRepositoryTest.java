package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberFollow;
import com.recipesns.core.repository.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class MemberFollowMainRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberFollowMainRepository memberFollowMainRepository;

    @Test
    @DisplayName("팔로우를 저장할 수 있다.")
    void save() {
        // given
        Member member1 = memberRepository.save(createMember());
        Member member2 = memberRepository.save(createMember());

        MemberFollow memberFollow = MemberFollow.builder()
                .follower(member1)
                .following(member2)
                .build();
        // when
        MemberFollow savedMemberFollow = memberFollowMainRepository.save(memberFollow);
        // then
        assertThat(savedMemberFollow.getId()).isNotNull();
        assertThat(savedMemberFollow.getFollower().getId()).isEqualTo(member1.getId());
        assertThat(savedMemberFollow.getFollowing().getId()).isEqualTo(member2.getId());
    }

    @Test
    @DisplayName("id 값으로 조회할 수 있다.")
    void findById() {
        // given
        Member member1 = memberRepository.save(createMember());
        Member member2 = memberRepository.save(createMember());

        MemberFollow memberFollow = MemberFollow.builder()
                .follower(member1)
                .following(member2)
                .build();

        MemberFollow savedMemberFollow = memberFollowMainRepository.save(memberFollow);
        // when
        MemberFollow findMemberFollow = memberFollowMainRepository.findById(memberFollow.getId()).get();
        // then
        assertThat(findMemberFollow.getId()).isEqualTo(savedMemberFollow.getId());
    }

    @Test
    @DisplayName("id 값으로 삭제할 수 있다.")
    void deleteById() {
        // given
        Member member1 = memberRepository.save(createMember());
        Member member2 = memberRepository.save(createMember());

        MemberFollow memberFollow = MemberFollow.builder()
                .follower(member1)
                .following(member2)
                .build();

        memberFollowMainRepository.save(memberFollow);
        Long id = memberFollowMainRepository.deleteById(memberFollow.getId());
        // when // then
        assertThatThrownBy(() -> memberFollowMainRepository.findById(id).get()).isInstanceOf(NoSuchElementException.class);
    }

    private static Member createMember() {
        return Member.builder()
                .username("rlagudwog")
                .password("asdasdasdasd123123")
                .nickname("nickname")
                .build();
    }
}