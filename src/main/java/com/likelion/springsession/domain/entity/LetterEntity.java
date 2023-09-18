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

public class LetterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY -> Auto
    private Long id;
    // 왜 private 인가,, -> 캡슐화 (속성은 주로 private 로,,) -> 접근은 '.'이 아니라 method 로,,

    private String title;

    @Column(nullable = false) // DB에 들어갈 때 nullable 확인
    private  String content;

    private String photo_url;

    private LocalDateTime created_at;

    @ManyToOne
    private BoxEntity box;

//    private int age;
//    // int -> 원시 타입 (null 불가 등,,) / INTEGER -> 래퍼 타입 (null 가능 등,,)
//
//    private boolean isAdult;
//    // Entity 에서 boolean 은 웬만하면 원시 클래스로 ,, (T or F 여야 하는데 null 상태가 추가되기 때문에 ,,)

    @Builder
    public LetterEntity(Long id, String title, String content, String photo_url, LocalDateTime created_at, BoxEntity box) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photo_url = photo_url;
        this.created_at = created_at;
        this.box = box;
    }
}
