package com.example.demo.web.controller;

import com.example.demo.service.MemberService;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public MemberCreateResponse create(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping("/{id}")
    public String getMember(@PathVariable("id") Long memberId) {
        // This is a placeholder implementation.
        return "Member ID: " + memberId;
    }
}
