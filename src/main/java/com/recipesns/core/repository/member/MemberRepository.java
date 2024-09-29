package com.recipesns.core.repository.member;

import com.recipesns.core.model.member.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByUsername(String username);

    Member update(Member member);
}
