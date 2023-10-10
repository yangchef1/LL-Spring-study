package com.likelion.springsession.service;

import com.likelion.springsession.domain.entity.MemberEntity;
import com.likelion.springsession.dto.request.MemberSignInRequest;
import com.likelion.springsession.dto.response.MemberGetResponse;
import com.likelion.springsession.repository.BoxJpaRepository;
import com.likelion.springsession.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final BoxJpaRepository boxJpaRepository;

    @Transactional
    public Long create(MemberSignInRequest request) {
        //TODO: create auth logic
        MemberEntity member = memberJpaRepository.save(
                MemberEntity.builder()
                        .nickname(request.nickname())
                        .username(request.username())
                        .build()
        );
        return member.getId();
    }

    public MemberGetResponse getById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

}
