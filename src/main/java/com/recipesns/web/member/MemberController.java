package com.recipesns.web.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.service.member.MemberService;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import com.recipesns.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ApiResponse<Member> signup(@RequestBody MemberCreateRequestDto dto) {
        return ApiResponse.success(memberService.joinMember(dto));
    }
}
