package com.recipesns.web.member;

import com.recipesns.core.service.member.MemberFollowService;
import com.recipesns.core.service.member.request.MemberFollowServiceRequest;
import com.recipesns.core.service.member.response.MemberFollowResponse;
import com.recipesns.web.argumentresolver.Login;
import com.recipesns.web.member.request.MemberFollowRequest;
import com.recipesns.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberFollowController {

    private final MemberFollowService memberFollowService;

    @PostMapping("/follow")
    public ApiResponse<MemberFollowResponse> follow(@Login Long memberId, @RequestBody MemberFollowRequest request) {
        return ApiResponse.success(memberFollowService.follow(MemberFollowServiceRequest.of(memberId, request.getFollowingId())));
    }

    @PostMapping("/unfollow")
    public ApiResponse<MemberFollowResponse> unFollow(@Login Long memberId, @RequestBody MemberFollowRequest request) {
        return ApiResponse.success(memberFollowService.unFollow(MemberFollowServiceRequest.of(memberId, request.getFollowingId())));
    }
}
