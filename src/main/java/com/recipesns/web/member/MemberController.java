package com.recipesns.web.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.service.member.LoginService;
import com.recipesns.core.service.member.MemberService;
import com.recipesns.web.member.dto.LoginRequestDto;
import com.recipesns.web.member.dto.MemberCreateRequestDto;
import com.recipesns.web.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.recipesns.web.exception.BusinessError.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public ApiResponse<Member> signup(@RequestBody MemberCreateRequestDto dto) {
        return ApiResponse.success(memberService.joinMember(dto));
    }

    @PostMapping("/login")
    public ApiResponse<Void> login(@RequestBody LoginRequestDto dto, HttpServletRequest request) {

        Member loginMember = loginService.login(dto.getUsername(), dto.getPassword());

        if (loginMember == null) {
            throw MEMBER_NOT_FOUND_ERROR.exception();
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return ApiResponse.success();
    }
}
