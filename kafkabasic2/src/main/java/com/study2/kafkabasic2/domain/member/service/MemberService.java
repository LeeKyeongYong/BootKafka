package com.study2.kafkabasic2.domain.member.service;

import com.study2.kafkabasic2.domain.member.entity.Member;
import com.study2.kafkabasic2.domain.member.repository.MemberRepository;
import com.study2.kafkabasic2.global.rsdata.RespData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public RespData<Member> join(String username, String password, String nickname) {
        return RespData.of(
                memberRepository.save(
                        Member.builder()
                                .username(username)
                                .password(password)
                                .nickname(nickname)
                                .build()
                )
        );
    }

    public long count(){
        return memberRepository.count();
    }

    @Transactional
    public void increasePostsCount(long id){
        findById(id).ifPresent(member ->{
            member.increasePostCount();
        });
    }

    private Optional<Member> findById(long id){
        return memberRepository.findById(id);
    }
}
