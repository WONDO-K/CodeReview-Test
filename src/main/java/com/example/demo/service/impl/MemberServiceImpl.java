package com.example.demo.service.impl;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberCreateResponse create(MemberCreateRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            // 코드리뷰 포인트: RuntimeException 말고 커스텀 예외/에러코드로 개선 가능
            throw new IllegalArgumentException("email already exists");
        }

        Member member = Member.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .build();

        Member saved = memberRepository.save(member);
        return new MemberCreateResponse(saved.getId());
    }


}
