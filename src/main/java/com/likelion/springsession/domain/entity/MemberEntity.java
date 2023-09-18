package com.likelion.springsession.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 는 기본 생성자를 반드시 만들어야 함
@Getter
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY -> Auto
    private Long id;
    // 왜 private 인가,, -> 캡슐화 (속성은 주로 private 로,,) -> 접근은 '.'이 아니라 method 로,,

    private String username;
    
    @Column(nullable = false) // DB에 들어갈 때 nullable 확인
    private  String nickname;

    private String password;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

//    private int age;
//    // int -> 원시 타입 (null 불가 등,,) / INTEGER -> 래퍼 타입 (null 가능 등,,)
//
//    private boolean isAdult;
//    // Entity 에서 boolean 은 웬만하면 원시 클래스로 ,, (T or F 여야 하는데 null 상태가 추가되기 때문에 ,,)

    @Builder
    public MemberEntity(Long id, String username, String nickname, String password, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
