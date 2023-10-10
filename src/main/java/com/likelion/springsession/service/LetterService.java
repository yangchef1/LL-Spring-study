package com.likelion.springsession.service;

import com.likelion.springsession.domain.entity.LetterEntity;
import com.likelion.springsession.dto.request.LetterCreateRequest;
import com.likelion.springsession.repository.LetterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterJpaRepository letterJpaRepository;

    @Transactional
    public String create(LetterCreateRequest request) {
        LetterEntity letter = letterJpaRepository.save(LetterEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        return letter.getId().toString();
    }


}
