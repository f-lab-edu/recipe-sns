package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberMapper;
import com.recipesns.repository.member.stub.MemoryMemberRepository;
import com.recipesns.web.exception.BusinessException;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberMapper memberMapper = new MemberMapper();

    MemberService memberService = new MemberService(memberRepository, memberMapper);

    @BeforeEach
    public void beForEach() {
        memberRepository.clearMemory();
    }

    @Test
    @DisplayName("회원가입시 확인 비밀번호가 일치하지 않으면 예외가 던져진다")
    void join_password_exception() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208")
                .nickname("rlagudwog")
                .build();
        assertThatThrownBy(() -> memberService.joinMember(dto))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("확인 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("회원가입시 중복된 아이디가 확인되면 예외가 던져진다")
    void join_duplicate_exception() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208!")
                .nickname("rlagudwog")
                .build();

        memberService.joinMember(dto);

        assertThatThrownBy(() -> memberService.joinMember(dto))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("중복된 아이디를 사용할 수 없습니다");
    }

    @Test
    @DisplayName("회원가입")
    void join_member_success() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208!")
                .nickname("rlagudwog")
                .build();

        Member savedMember = memberService.joinMember(dto);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        assertThat(savedMember).isEqualTo(findMember.get());
    }
}