package com.likelion.springsession.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion.springsession.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

// 껍데기라 상대적으로 관대하게 ,,,
@Data // getter, setter, toString, requireArgsConstructor 등,, 포함되어 있음
@AllArgsConstructor
public class MemberGetResponse {

    @JsonProperty("멤버 이름") // JSON 으로 파싱하면 해당 값("멤버 이름")을 키 값으로 사용
    private String nickname;
    private String username;

    public static MemberGetResponse of(MemberEntity member) {
        return new MemberGetResponse(member.getNickname(), member.getUsername());
    }
}
