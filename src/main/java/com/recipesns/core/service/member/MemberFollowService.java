package com.recipesns.core.service.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.member.MemberFollow;
import com.recipesns.core.repository.member.MemberFollowRepository;
import com.recipesns.core.repository.member.MemberRepository;
import com.recipesns.core.service.member.request.MemberFollowServiceRequest;
import com.recipesns.core.service.member.response.MemberFollowResponse;
import com.recipesns.web.exception.BusinessError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFollowService {

    private final MemberRepository memberRepository;
    private final MemberFollowRepository memberFollowRepository;

    @Transactional
    public MemberFollowResponse follow(MemberFollowServiceRequest request) {

        memberFollowRepository.findByFollowerIdAndFollowingId(request.getFollowerId(), request.getFollowingId())
                .ifPresent(memberFollow -> {
                    throw BusinessError.MEMBER_FOLLOW_DUPLICATE_ERROR.exception();
                });

        Member follower = memberRepository.findById(request.getFollowerId())
                .orElseThrow(BusinessError.MEMBER_NOT_FOUND_ERROR::exception);

        Member following = memberRepository.findById(request.getFollowingId())
                .orElseThrow(BusinessError.MEMBER_NOT_FOUND_ERROR::exception);

        MemberFollow memberFollow = MemberFollow.create(follower, following);

        memberFollowRepository.save(memberFollow);
        return MemberFollowResponse.of(memberFollow);
    }

    @Transactional
    public MemberFollowResponse unFollow(MemberFollowServiceRequest request) {
        MemberFollow memberFollow = memberFollowRepository.findByFollowerIdAndFollowingId(request.getFollowerId(), request.getFollowingId())
                .orElseThrow(BusinessError.MEMBER_FOLLOW_NOT_FOUND_ERROR::exception);

        memberFollowRepository.deleteById(memberFollow.getId());

        return MemberFollowResponse.of(memberFollow);
    }
}
