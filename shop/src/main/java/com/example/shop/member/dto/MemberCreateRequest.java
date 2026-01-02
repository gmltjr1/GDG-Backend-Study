package com.example.shop.member.dto;

// loginId, password, phoneNumber, address

import lombok.Getter;

@Getter

public class MemberCreateRequest {

    @NotNull(message ="아이디는 필수입니다")
    @Size(min=4, max=20, message="아이디는 4자 이상 20자 이하로 입력해주세요")
    private String loginId;

    @NotNull(message ="비밀번호는 필수입니다")
    @Size(min=8, max=20, message="비밀번호는 8자 이상 20자 이하로 입력해주세요")
    private String password;

    @NotNull(message ="전화번호는 필수입니다")
    @Pattern(regexp="010-\\d{4}-\\d{4}", message = "전화번호 형식은 010-xxxx-xxxx 입니다.")
    private String phoneNumber;
    
    @NotNull(message ="주소는 필수입니다")
    @Size(min=1, max=255, message="주소는 1자 이상 255자 이하로 입력해주세요")
    private String address;

    public MemberCreateRequest(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
