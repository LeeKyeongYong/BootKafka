package com.study2.kafkabasic2.domain.noti.service;

import com.study2.kafkabasic2.domain.member.entity.Member;
import com.study2.kafkabasic2.domain.member.service.MemberService;
import com.study2.kafkabasic2.domain.noti.entity.Noti;
import com.study2.kafkabasic2.domain.noti.repository.NotiRepository;
import com.study2.kafkabasic2.domain.post.entity.Post;
import com.study2.kafkabasic2.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotiService {
    private final MemberService memberService;
    private final PostService postService;
    private final NotiRepository notiRepository;

    @Transactional
    public void postCreated(Post post) {
        Member actor = postService.of(post.getAuthor());

        List<Member> receivers = memberService
                .findAll()
                .stream()
                .filter(member -> !member.equals(actor))
                .toList();

        receivers.forEach(receiver -> {
                    Noti noti = Noti.builder()
                            .actor(actor)
                            .receiver(receiver)
                            .relTypeCode(post.getModelName())
                            .relId(post.getId())
                            .typeCode("POST")
                            .type2Code("CREATED")
                            .readStatus(false)
                            .build();

                    notiRepository.save(noti);
                }
        );
    }
}