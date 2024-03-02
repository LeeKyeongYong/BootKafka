package com.study2.kafkabasic2.domain.post.service;

import com.study2.kafkabasic2.domain.member.service.MemberService;
import com.study2.kafkabasic2.domain.post.entity.Post;
import com.study2.kafkabasic2.domain.post.repository.PostRepository;
import com.study2.kafkabasic2.global.event.PostCreatedEvent;
import com.study2.kafkabasic2.domain.post.author.entity.Author;
import com.study2.kafkabasic2.global.rsdata.RespData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study2.kafkabasic2.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public RespData<Post> write(Author author, String title) {
        author.increasePostsCount();

        Post post = postRepository.save(
                post.builder()
                        .author(author)
                        .title(title)
                        .build()
        );
        publisher.publishEvent(new PostCreatedEvent(this,post));
        return RespData.of(post);
    }

    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }
}
