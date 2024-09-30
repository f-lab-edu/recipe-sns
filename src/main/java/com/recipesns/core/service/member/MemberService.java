package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberMapper;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.recipesns.web.exception.BusinessError.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public Member joinMember(MemberCreateRequestDto dto) {
        if (!dto.checkPassword()) {
            throw MEMBER_PASSWORD_CONFIRMATION_ERROR.exception();
        }
        Member member = memberMapper.from(dto);
        Optional<Member> duplicatedMember = memberRepository.findByUsername(member.getUsername());
        if (duplicatedMember.isPresent()) {
            throw MEMBER_DUPLICATE_ERROR.exception();
        }
        return memberRepository.save(member);
    }
}
