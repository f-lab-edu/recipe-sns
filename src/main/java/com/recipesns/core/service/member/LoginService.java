package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.security.encoder.PasswordEncoder;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.web.member.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.recipesns.web.exception.BusinessError.MEMBER_NOT_FOUND_ERROR;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member login(LoginRequestDto dto) {
        dto.validate();
        return memberRepository.findByUsername(dto.getUsername())
                .filter(member -> passwordEncoder.matches(dto.getPassword(), member.getPassword()))
                .orElseThrow(MEMBER_NOT_FOUND_ERROR::exception);
    }
}
