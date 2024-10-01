package com.recipesns.core.security.encoder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BCryptPasswordEncoderTest {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    @DisplayName("패스워드를 인코딩하고 결과가 null이 아니며 원본과 다른지 검증")
    void encode() {
        String password = "hp12081208!";

        String encodedPassword = passwordEncoder.encode(password);

        assertThat(encodedPassword).isNotNull();
        assertThat(encodedPassword).isNotEqualTo(password);
    }

    @Test
    @DisplayName("인코딩된 패스워드와 원본 패스워드가 일치하는지 검증")
    void matches() {
        String password = "hp12081208!";
        String encodedPassword = passwordEncoder.encode(password);

        boolean isMatch = passwordEncoder.matches(password, encodedPassword);

        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("잘못된 패스워드로 일치 여부를 확인하여 실패하는지 검증")
    void matches_with_wrong_password() {
        String password = "hp12081208!";
        String wrongPassword = "hp12081208";
        String encodedPassword = passwordEncoder.encode(password);

        boolean isMatch = passwordEncoder.matches(wrongPassword, encodedPassword);

        assertThat(isMatch).isFalse();
    }
}