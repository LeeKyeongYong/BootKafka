package com.study2.kafkabasic2.domain.post.repository;

import com.study2.kafkabasic2.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
