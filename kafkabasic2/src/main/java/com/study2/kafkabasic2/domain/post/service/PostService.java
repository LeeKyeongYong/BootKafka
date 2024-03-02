package com.study2.kafkabasic2.domain.post.service;

import com.study2.kafkabasic2.domain.post.entity.Post;
import com.study2.kafkabasic2.domain.post.repository.PostRepository;
import com.study2.kafkabasic2.global.jpa.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
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

    @Transactional
    public RespData<Post> write(Author author, String title) {
        return RespData.of(
                postRepository.save(
                        Post.builder()
                                .author(author)
                                .title(title)
                                .build()
                )
        );
    }

    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }
}