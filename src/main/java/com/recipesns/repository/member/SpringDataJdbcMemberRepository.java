package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataJdbcMemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
