package com.example.demo.service.impl;

import com.example.demo.domain.Member;
import com.example.demo.domain.dto.MemberResponse;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import com.example.demo.web.dto.MemberCreateRequest;
import com.example.demo.web.dto.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<MemberResponse> getAllMembers() { // DTO 반환으로 변경
        return memberRepository.findAll().stream()
                .map(MemberResponse::from) // 엔티티를 DTO로 매핑
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponse getMember(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        return findMember.map(MemberResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
    }
}
