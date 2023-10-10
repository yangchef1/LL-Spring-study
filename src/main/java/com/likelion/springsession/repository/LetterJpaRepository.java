package com.likelion.springsession.repository;

import com.likelion.springsession.domain.entity.LetterEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {

    default LetterEntity findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 편지를 찾을 수 없습니다."));
    }
}