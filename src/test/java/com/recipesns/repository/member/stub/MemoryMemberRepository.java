package com.recipesns.repository.member.stub;

import com.recipesns.core.model.member.Member;
import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostLike;
import com.recipesns.core.repository.member.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        sequence++;
        member.setId(sequence);
        store.put(sequence, member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        for (Member member : store.values()) {
            if (member.getUsername().equals(username)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    @Override
    public Member update(Member member) {
        return null;
    }

    public void clearMemory() {
        sequence = 0L;
        store.clear();
    }
}
