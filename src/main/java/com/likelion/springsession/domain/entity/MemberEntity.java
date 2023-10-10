package com.likelion.springsession.domain.entity;

import com.likelion.springsession.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 는 기본 생성자를 반드시 만들어야 함
@Getter
// 컴파일 시, 알아서 getter 만들어 줌. (get + 멤버 변수 이름)
// setter는 잘 사용 X -> 필요한 경우, 비즈니스 로직에 맞는 이름으로 직접 정의해서 사용하는 걸 추천!
@Table(name="member")
// 별도로 Table name option을 저장해주지 않으면, snake 형식으로 저장 (member_entity)
public class MemberEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY -> Auto
    private Long id;
    // 왜 private 인가,, -> 캡슐화 (속성은 주로 private 로,,) -> 접근은 '.'이 아니라 method 로,,

    private String username;
    
    @Column(nullable = false) // DB에 들어갈 때 nullable 확인
    private  String nickname;

    private String password;

//    private int age;
//    // int -> 원시 타입 (null 불가 등,,) / INTEGER -> 래퍼 타입 (null 가능 등,,)
//
//    private boolean isAdult;
//    // Entity 에서 boolean 은 웬만하면 원시 클래스로 ,, (T or F 여야 하는데 null 상태가 추가되기 때문에 ,,)



    @Builder
    public MemberEntity(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

    // @Builder 사용하면 new 대신
    // .builder
    //      .name()
    //      .nickname()
    //      .build 형식으로 생성자 호출 가능 (property 헷갈리지 않을 수 있음)
}
