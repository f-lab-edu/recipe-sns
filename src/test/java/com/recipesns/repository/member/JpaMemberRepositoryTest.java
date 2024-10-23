package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class JpaMemberRepositoryTest {

    @Autowired
    private JpaMemberRepository jpaMemberRepository;

    @Test
    @DisplayName("아이디로 회원을 조회할 수 있다.")
    void findByUsername() {

        //given
        Member member = Member.builder()
                .username("rlagudwog")
                .password("password")
                .nickname("닉네임")
                .build();

        jpaMemberRepository.save(member);

        //when
        Member findMember = jpaMemberRepository.findByUsername("rlagudwog").get();

        //then
        assertThat(findMember).isEqualTo(member);
    }
}