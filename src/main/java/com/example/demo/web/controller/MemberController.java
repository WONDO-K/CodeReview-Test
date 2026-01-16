package com.example.demo.web.controller;

import com.example.demo.service.MemberService;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add")
    public MemberCreateResponse create(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }
}
