package com.likelion.springsession.controller;

import com.likelion.springsession.dto.response.MemberGetResponse;
import com.likelion.springsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
// 의존성 주입을 해주는 생성자를 만들어줌.
// ex)
// public final MemberService memberService;
//
// public MemberController(MemberService memberService) {
//      this.memberService = memberService;
// }
public class MemberController {

    public final MemberService memberService;
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("member")Long memberId){
        return ResponseEntity.ok(memberService.getById(memberId));
    }
}
