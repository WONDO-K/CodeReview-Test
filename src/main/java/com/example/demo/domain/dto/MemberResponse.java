package com.example.demo.domain.dto;

import com.example.demo.domain.Member;

public record MemberResponse(
        Long id,
        String username,
        String email
        // 필요에 따라 추가 필드 정의
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getUsername(),
                member.getEmail()
        );
    }
}
