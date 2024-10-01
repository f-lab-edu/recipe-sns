package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberMapper;
import com.recipesns.core.security.encoder.BCryptPasswordEncoder;
import com.recipesns.core.security.encoder.PasswordEncoder;
import com.recipesns.repository.member.stub.MemoryMemberRepository;
import com.recipesns.web.exception.BusinessException;
import com.recipesns.web.member.dto.LoginRequestDto;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LoginServiceTest {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final LoginService loginService = new LoginService(memberRepository, passwordEncoder);

    private final MemberMapper memberMapper = new MemberMapper(passwordEncoder);

    @BeforeEach
    public void beForEach() {
        memberRepository.clearMemory();
    }

    @Test
    @DisplayName("로그인시 비밀번호가 틀리면 예외가 던져진다")
    void login_password_exception() {

        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208!")
                .nickname("rlagudwog")
                .build();
        Member member = memberMapper.from(dto);
        memberRepository.save(member);

        LoginRequestDto loginDto = LoginRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208")
                .build();

        assertThatThrownBy(() -> loginService.login(loginDto))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("아이디 또는 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("로그인시 아이디가 틀리면 예외가 던져진다")
    void login_username_exception() {

        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208!")
                .nickname("rlagudwog")
                .build();
        Member member = memberMapper.from(dto);
        memberRepository.save(member);

        LoginRequestDto loginDto = LoginRequestDto.builder()
                .username("kimbro9")
                .password("hp12081208!")
                .build();

        assertThatThrownBy(() -> loginService.login(loginDto))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("아이디 또는 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("로그인 성공")
    void login_success() {

        MemberCreateRequestDto dto = MemberCreateRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .confirmPassword("hp12081208!")
                .nickname("rlagudwog")
                .build();
        Member member = memberMapper.from(dto);
        Member savedMember = memberRepository.save(member);

        LoginRequestDto loginDto = LoginRequestDto.builder()
                .username("kimbro97")
                .password("hp12081208!")
                .build();

        Member loginMember = loginService.login(loginDto);

        assertThat(savedMember).isEqualTo(loginMember);

    }
}