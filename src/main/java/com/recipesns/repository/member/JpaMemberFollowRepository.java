package com.recipesns.repository.member;

import com.recipesns.core.model.member.MemberFollow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberFollowRepository extends JpaRepository<MemberFollow, Long> {
    Optional<MemberFollow> findByFollowerIdAndFollowingId(Long FollowerId, Long FollowingId);
}
