package com.recipesns.repository.member;

import com.recipesns.core.model.member.MemberFollow;
import com.recipesns.core.repository.member.MemberFollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberFollowMainRepository implements MemberFollowRepository {

    private final JpaMemberFollowRepository jpaMemberFollowRepository;

    @Override
    public MemberFollow save(MemberFollow memberFollow) {
        return jpaMemberFollowRepository.save(memberFollow);
    }

    @Override
    public Optional<MemberFollow> findById(Long id) {
        return jpaMemberFollowRepository.findById(id);
    }

    @Override
    public Long deleteById(Long id) {
        jpaMemberFollowRepository.deleteById(id);
        return id;
    }
}
