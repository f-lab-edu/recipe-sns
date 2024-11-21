package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.repository.member.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class JdbcMemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    private static Member member;

    @BeforeEach
    public void beForEach() {
        member = Member.builder()
                .username("rlagudwog")
                .password("asdfsdwq12")
                .nickname("kimbro97")
                .build();
    }

    @Test
    void save() {
        Member savedMember = memberRepository.save(member);
        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    void findById() {
        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember.get().getId()).isEqualTo(savedMember.getId());
    }

    @Test
    void findByUsername() {
        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findByUsername(savedMember.getUsername());
        assertThat(savedMember).isEqualTo(findMember.get());
    }
}