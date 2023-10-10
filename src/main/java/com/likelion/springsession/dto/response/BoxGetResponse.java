package com.likelion.springsession.dto.response;
import com.likelion.springsession.domain.entity.BoxEntity;

// record는 불변한 data 클래스를 정의할 때 사용.
// 1. 일반적인 class와 다르게 getter, hashCode, equals, toString 메서드를 기본 제공.
// 2. 생성자는 모든 field 포함
// 3. 다른 class를 상속받을 수 없음. (기본적으로 java.lang.Record를 상속 받기 때문)
// 4. final class임.
// -> 주로 DTO 작성에 사용됨. (Test 코드 작성에 사용하기도 함)
public record BoxGetResponse(
        String name
) {
    public static BoxGetResponse of(BoxEntity box) {
        return new BoxGetResponse(box.getName());
    }
}
