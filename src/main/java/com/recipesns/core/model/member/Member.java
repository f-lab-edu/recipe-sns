package com.recipesns.core.model.member;

import lombok.Getter;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Table("MEMBER")
public class Member {

    @Id
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime withdrawalAt;

    @Builder
    public Member(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.withdrawalAt = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(username, member.username) && Objects.equals(password, member.password) && Objects.equals(nickname, member.nickname) && Objects.equals(createdAt, member.createdAt) && Objects.equals(updatedAt, member.updatedAt) && Objects.equals(withdrawalAt, member.withdrawalAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, nickname, createdAt, updatedAt, withdrawalAt);
    }
    // 테스트 용도
    public void setId(Long sequence) {
        this.id = sequence;
    }
}
