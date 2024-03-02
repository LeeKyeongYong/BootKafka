package com.study2.kafkabasic2.domain.post.author.service;

import com.study2.kafkabasic2.domain.post.author.entity.Author;
import com.study2.kafkabasic2.domain.post.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }
}
