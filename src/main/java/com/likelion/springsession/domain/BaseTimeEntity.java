package com.likelion.springsession.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 createDate, modifiedDate 를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함
public class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdAt;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime updatedAt;
}
