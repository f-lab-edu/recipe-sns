package com.recipesns.core.model.member;

import com.recipesns.web.member.dto.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    public Member from(MemberCreateRequestDto dto) {
        return Member.builder()
                .username(dto.getUsername())
                .password(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()))
                .nickname(dto.getNickname())
                .build();
    }
}
