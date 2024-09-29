package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberMapper;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.recipesns.web.exception.BusinessError.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member joinMember(MemberCreateRequestDto dto) {
        Member member = memberMapper.from(dto);
        Optional<Member> duplicatedMember = memberRepository.findByUsername(member.getUsername());
        if (duplicatedMember.isPresent()) {
            throw MEMBER_DUPlICATION_ERROR.exception();
        }
        return memberRepository.save(member);
    }
}
