package com.recipesns.core.repository.member;

import com.recipesns.core.model.member.MemberFollow;

import java.util.Optional;

public interface MemberFollowRepository {
    MemberFollow save(MemberFollow memberFollow);
    Optional<MemberFollow> findById(Long id);
    Long deleteById(Long id);
    Optional<MemberFollow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
}
