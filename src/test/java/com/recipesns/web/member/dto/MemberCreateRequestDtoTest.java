package com.recipesns.web.member.dto;

import com.recipesns.web.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberCreateRequestDtoTest {

    @Test
    @DisplayName("아이디가 null이면 예외가 던져진다")
    void username_null_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
    }

    @Test
    @DisplayName("아이디가 빈값이면 예외가 던져진다")
    void username_blank_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
    }

    @Test
    @DisplayName("아이디가 영어, 숫자의 조합으로 6자 이상 12자 이하가 아니면 예외가 던져진다")
    void username_pattern_validate() {
        // 영문으로 6자 (숫자 미포함)
        MemberCreateRequestDto dto1 = MemberCreateRequestDto.builder().username("kimbro").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();

        // 영문 숫자 조합 6자 미만
        MemberCreateRequestDto dto2 = MemberCreateRequestDto.builder().username("kim12").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();

        // 영문 숫자 조합 12자 초과
        MemberCreateRequestDto dto3 = MemberCreateRequestDto.builder().username("kimbr01234567").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();

        // 숫자만으로 구성된 아이디
        MemberCreateRequestDto dto4 = MemberCreateRequestDto.builder().username("123456").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();

        // 검증 예외 발생 확인
        assertThatThrownBy(() -> dto1.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
        assertThatThrownBy(() -> dto2.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
        assertThatThrownBy(() -> dto3.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
        assertThatThrownBy(() -> dto4.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디는 영어, 숫자의 조합으로 6자 이상이어야 합니다");
    }

    @Test
    @DisplayName("패스워드가 null이면 예외가 던져진다")
    void password_null_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").confirmPassword("hp12081208!").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
    }

    @Test
    @DisplayName("패스워드가 빈값이면 예외가 던져진다")
    void password_blank_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("").confirmPassword("hp12081208!").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
    }

    @Test
    @DisplayName("패스워드가 영문, 숫자, 특수문자의 조합으로 8자 이상 16자 이하가 아니면 예외가 던져진다")
    void password_pattern_validate() {
        // 영문 숫자 특수문자 조합 8자 미만
        MemberCreateRequestDto dto1 = MemberCreateRequestDto.builder().username("kimbro97").password("hp12!").confirmPassword("hp12!").nickname("rlagudwog").build();

        // 숫자, 특수문자 없는 비밀번호
        MemberCreateRequestDto dto2 = MemberCreateRequestDto.builder().username("kimbro97").password("abcdefgh").confirmPassword("abcdefgh").nickname("rlagudwog").build();

        // 특수문자가 없는 비밀번호
        MemberCreateRequestDto dto3 = MemberCreateRequestDto.builder().username("kimbro97").password("abc12345").confirmPassword("abc12345").nickname("rlagudwog").build();

        // 영문, 숫자, 특수문자 포함 16자 초과
        MemberCreateRequestDto dto4 = MemberCreateRequestDto.builder().username("kimbro97").password("abc12345$abc12345").confirmPassword("abc12345$abc12345").nickname("rlagudwog").build();

        // 빈 문자열 패스워드
        MemberCreateRequestDto dto5 = MemberCreateRequestDto.builder().username("kimbro97").password("").confirmPassword("").nickname("rlagudwog").build();

        assertThatThrownBy(() -> dto1.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
        assertThatThrownBy(() -> dto2.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
        assertThatThrownBy(() -> dto3.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
        assertThatThrownBy(() -> dto4.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
        assertThatThrownBy(() -> dto5.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호는 영어, 숫자, 특수문자의 조합으로 8자 이상이어야 합니다");
    }

    @Test
    @DisplayName("확인 패스워드가 null이면 예외가 던져진다")
    void confirm_password_null_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("확인 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("확인 패스워드가 빈값이면 예외가 던져진다")
    void confirm_password_blank_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").confirmPassword("").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("확인 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("확인 패스워드가 패스워드와 일치하지 않으면 예외가 던져진다")
    void confirm_password_match_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").confirmPassword("hp12081208").nickname("rlagudwog").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("확인 비밀번호를 확인해주세요");
    }

    @Test
    @DisplayName("닉네임이 null이면 예외가 던져진다")
    void nickname_null_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").confirmPassword("hp12081208!").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("닉네임을 입력해주세요");
    }

    @Test
    @DisplayName("닉네임이 빈값이면 예외가 던져진다")
    void nickname_password_blank_validate() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").confirmPassword("hp12081208!").nickname("").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("닉네임을 입력해주세요");
    }

    @Test
    @DisplayName("validate 성공")
    void validate_success() {
        MemberCreateRequestDto dto = MemberCreateRequestDto.builder().username("kimbro97").password("hp12081208!").confirmPassword("hp12081208!").nickname("rlagudwog").build();
        assertThat(dto.validate()).isTrue();
    }
}