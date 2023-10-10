package com.likelion.springsession.service;

import com.likelion.springsession.domain.entity.BoxEntity;
import com.likelion.springsession.domain.entity.MemberEntity;
import com.likelion.springsession.dto.request.BoxCreateRequest;
import com.likelion.springsession.dto.response.BoxGetResponse;
import com.likelion.springsession.repository.BoxJpaRepository;
import com.likelion.springsession.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {
    private final BoxJpaRepository boxJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    public BoxGetResponse getByCode(String boxCode) {
        return BoxGetResponse.of(boxJpaRepository.findByCodeOrThrow(boxCode));
    }

    @Transactional
    public String create(BoxCreateRequest request, Long memberId) {
        BoxEntity box = boxJpaRepository.save(
                BoxEntity.builder()
                        .name(request.name())
                        .code(generateCode())
                        .member(findMemberById(memberId))
                        .build()
        );
        return box.getCode();
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private MemberEntity findMemberById(Long memberId) {
        return memberJpaRepository.findByIdOrThrow(memberId);
    }
}
