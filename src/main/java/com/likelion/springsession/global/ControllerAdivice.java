package com.likelion.springsession.global;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// 모든 controller에서 공통적인 처리를 위한 어노테이션. (중복 코드 제거)
// 일반적으로 다음 2가지 기능을 공통 적용하기 위해 사용.
// 1. @ExceptionHandler -> 모든 controller에서 발생하는 예외 처리를 중앙에서 ,,
// 2. @ModelAttribute -> 모든 controller에 공통적으로 적용되는 모델 속성 부여
public class ControllerAdivice {

    @ExceptionHandler
    public ResponseEntity<Void> handleEntityExistsException(EntityExistsException e) {
        return ResponseEntity.notFound().build();
    }
}
