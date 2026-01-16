package com.example.demo.service;

import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;

public interface MemberService {
    MemberCreateResponse create(MemberCreateRequest request);
}
