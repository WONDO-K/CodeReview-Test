package com.example.demo.web.controller;

import com.example.demo.domain.Member;
import com.example.demo.domain.dto.MemberResponse;
import com.example.demo.service.MemberService;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add")
    public MemberCreateResponse create(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable("id") Long memberId) {
        // This is a placeholder implementation.
        return memberService.getMember(memberId);
    }

    @GetMapping
    public List<MemberResponse> getAllMembers() { // DTO 반환으로 변경
        return memberService.getAllMembers();
    }

}
