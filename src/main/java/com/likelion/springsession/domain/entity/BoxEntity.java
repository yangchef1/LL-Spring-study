package com.likelion.springsession.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 는 기본 생성자를 반드시 만들어야 함
@Getter
@Table(name="box")
public class BoxEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20; // 정적 상수

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY -> Auto
    private Long id;
    // 왜 private 인가,, -> 캡슐화 (속성은 주로 private 로,,) -> 접근은 '.'이 아니라 method 로,,

    private String name;

    private int letterLimit = DEFAULT_LETTER_LIMIT;

    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    // 양방향 연관관계 (box에서 letter를 참조할 일이 많을 때 사용)
    // @OneToMany(mappedBy = "box")
    // private final List<LetterEntity> new ArrayList<>();

    @Builder
    public BoxEntity(String name, int letterLimit, String code, MemberEntity member) {
        this.name = name;
        validate(letterLimit);
        this.code = code;
        this.member = member;
    }

    private void validate(int letterLimit) {
        validateLetterLimit(letterLimit);
    }


    private void validateLetterLimit(int letterLimit) {
        if (letterLimit > DEFAULT_LETTER_LIMIT || letterLimit < 0) {
            throw new IllegalArgumentException("Invalid Letter Limit");
        }
    }
}
