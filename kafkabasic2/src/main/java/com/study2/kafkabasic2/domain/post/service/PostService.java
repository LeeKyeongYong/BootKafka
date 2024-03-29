package com.study2.kafkabasic2.domain.post.service;

import com.study2.kafkabasic2.domain.member.service.MemberService;
import com.study2.kafkabasic2.domain.post.entity.Post;
import com.study2.kafkabasic2.domain.post.repository.PostRepository;
import com.study2.kafkabasic2.global.dto.chat.ChatMessageDto;
import com.study2.kafkabasic2.global.event.PostCreatedEvent;
import com.study2.kafkabasic2.domain.post.author.entity.Author;
import com.study2.kafkabasic2.global.rsdata.RespData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study2.kafkabasic2.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher publisher;
    private final KafkaTemplate<Object, Object> template;

    @Transactional
    public RespData<Post> write(Author author, String title) {
        author.increasePostsCount();

        Post post = postRepository.save(
                Post.builder()
                        .author(author)
                        .title(title)
                        .build()
        );

        publisher.publishEvent(new PostCreatedEvent(this, post));
        template.send("chat-room-1", new ChatMessageDto(post.getId() + "번 글이 등록되었습니다."));

        return RespData.of(post);
    }

    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }

    public Member of(Author author) {
        return entityManager.getReference(Member.class, author.getId());
    }
}