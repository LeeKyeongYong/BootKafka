package com.study2.kafkabasic2.domain.member.service;

import com.study2.kafkabasic2.domain.member.entity.Member;
import com.study2.kafkabasic2.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member join(String username, String passwrd, String nickname){
        return memberRepository.save(
                Member.builder()
                        .username(username)
                        .password(passwrd)
                        .nickname(nickname)
                        .build()
        );
    }

    public long count(){
        return memberRepository.count();
    }
}