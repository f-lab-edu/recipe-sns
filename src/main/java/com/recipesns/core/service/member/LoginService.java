package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static com.recipesns.web.exception.BusinessError.MEMBER_NOT_FOUND_ERROR;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String username, String password) {
        return memberRepository.findByUsername(username)
                .filter(member -> BCrypt.checkpw(password, member.getPassword()))
                .orElseThrow(MEMBER_NOT_FOUND_ERROR::exception);
    }
}
