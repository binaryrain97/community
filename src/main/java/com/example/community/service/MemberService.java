package com.example.community.service;

import com.example.community.model.entity.Member;
import com.example.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String userId, String password) {
        Member member = Member.builder().userId(userId)
                .password(passwordEncoder.encode(password)).build();
        this.memberRepository.save(member);
    }
}
