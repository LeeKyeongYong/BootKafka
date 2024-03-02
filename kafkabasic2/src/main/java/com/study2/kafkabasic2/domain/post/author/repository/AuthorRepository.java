package com.study2.kafkabasic2.domain.post.author.repository;

import com.study2.kafkabasic2.domain.post.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
