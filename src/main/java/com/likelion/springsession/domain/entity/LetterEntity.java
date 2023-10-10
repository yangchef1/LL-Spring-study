package com.likelion.springsession.domain.entity;

import com.likelion.springsession.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.prefs.BackingStoreException;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 는 기본 생성자를 반드시 만들어야 함
@Getter
@Table(name="letter")
public class LetterEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY -> Auto
    private Long id;
    // 왜 private 인가,, -> 캡슐화 (속성은 주로 private 로,,) -> 접근은 '.'이 아니라 method 로,,

    @Column(nullable = false)
    private String title;

    @Column(nullable = false) // DB에 들어갈 때 nullable 확인
    private  String content;

    private String photo_url;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    private BoxEntity box;
    // 연관 관계의 주인 (1대N에서 N인 쪽)

    // 단방향 연관관계
    // 1. 즉시 로딩 (EAGER) - 메서드 호출 시, 데이터를 바로 불러옴.
    // 2. 지연 로딩 (LAZY) - 메서드 호출 시, 껍데기만 가져오고 실제 DB 변경이 필요한 상황에 데이터를 전부 불러옴.
    // # 단, 즉시 로딩과 지연 로딩을 혼용하면
    // -> 다중 스레드 이용 시, 데이터 변경 시점에 대한 관리가 필요.
    // -> 따라서, 지연 로딩으로 통일하여 사용하는 게,,,


    @Builder
    public LetterEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }


}

