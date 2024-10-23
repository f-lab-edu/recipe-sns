package com.recipesns.core.model.member;

import com.recipesns.core.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime withdrawalAt;

    @Builder
    public Member(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.withdrawalAt = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(username, member.username) && Objects.equals(password, member.password) && Objects.equals(nickname, member.nickname) && Objects.equals(withdrawalAt, member.withdrawalAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, nickname, withdrawalAt);
    }
    // 테스트 용도
    public void setId(Long sequence) {
        this.id = sequence;
    }
}
