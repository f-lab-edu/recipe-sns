package com.recipesns.repository.post;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recipesns.core.model.post.Post;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.recipesns.core.model.member.QMemberFollow.memberFollow;
import static com.recipesns.core.model.post.QPost.post;


public class JpaPostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public JpaPostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Post> findPostsByFollowedMembers(Long memberId, Pageable pageable) {
        QueryResults<Post> results = queryFactory
                .selectFrom(post)
                .where(post.member.id.in(
                        JPAExpressions.select(memberFollow.following.id)
                                .from(memberFollow)
                                .where(memberFollow.follower.id.eq(memberId))
                ))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<Post> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }
}
