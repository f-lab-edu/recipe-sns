package com.recipesns.web.member.dto;

import com.recipesns.web.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LoginRequestDtoTest {
    @Test
    @DisplayName("아이디가 null이면 예외가 던져진다")
    void username_null_validate() {
        LoginRequestDto dto = LoginRequestDto.builder().password("hp12081208!").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디를 입력해주세요");
    }

    @Test
    @DisplayName("아이디가 빈값이면 예외가 던져진다")
    void username_blank_validate() {
        LoginRequestDto dto = LoginRequestDto.builder().username("").password("hp12081208!").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("아이디를 입력해주세요");
    }

    @Test
    @DisplayName("비밀번호가 null이면 예외가 던져진다")
    void password_null_validate() {
        LoginRequestDto dto = LoginRequestDto.builder().username("kimbro97").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호를 입력해주세요");
    }

    @Test
    @DisplayName("비밀번호가 빈값이면 예외가 던져진다")
    void password_blank_validate() {
        LoginRequestDto dto = LoginRequestDto.builder().username("kimbro97").password("").build();
        assertThatThrownBy(() -> dto.validate()).isInstanceOf(BusinessException.class).hasMessageContaining("비밀번호를 입력해주세요");
    }

    @Test
    @DisplayName("validate 성공")
    void validate_success() {
        LoginRequestDto dto = LoginRequestDto.builder().username("kimbro97").password("hp12081208!").build();
        assertThat(dto.validate()).isTrue();
    }
}