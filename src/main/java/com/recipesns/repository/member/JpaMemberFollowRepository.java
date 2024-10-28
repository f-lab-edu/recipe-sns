package com.recipesns.repository.member;

import com.recipesns.core.model.member.MemberFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberFollowRepository extends JpaRepository<MemberFollow, Long> {
}
