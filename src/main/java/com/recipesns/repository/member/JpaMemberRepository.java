package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
