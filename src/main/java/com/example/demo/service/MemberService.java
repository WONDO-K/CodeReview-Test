package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.dto.MemberResponse;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;

import java.util.List;

public interface MemberService {
    MemberCreateResponse create(MemberCreateRequest request);

    List<MemberResponse> getAllMembers(); // DTO 반환으로 변경
}
