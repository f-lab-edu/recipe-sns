package com.recipesns.core.model.member;

import com.recipesns.core.security.encoder.PasswordEncoder;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final PasswordEncoder passwordEncoder;

    public Member from(MemberCreateRequestDto dto) {
        return Member.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .nickname(dto.getNickname())
                .build();
    }
}
