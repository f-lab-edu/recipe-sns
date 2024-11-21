package com.recipesns.repository.member;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcMemberRepository implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public Member save(Member member) {
        return jpaMemberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jpaMemberRepository.findById(id);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
         return jpaMemberRepository.findByUsername(username);
    }

    @Override
    public Member update(Member member) {
        return null;
    }
}
