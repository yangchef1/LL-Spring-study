package com.likelion.springsession.dto.request;

public record MemberSignInRequest(
        String username,
        String password,
        String nickname
) {
}