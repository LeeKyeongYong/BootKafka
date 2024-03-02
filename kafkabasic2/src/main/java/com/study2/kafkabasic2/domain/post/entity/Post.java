package com.study2.kafkabasic2.domain.post.entity;

import com.study2.kafkabasic2.domain.post.author.entity.Author;
import com.study2.kafkabasic2.global.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;
@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class Post extends BaseTime {
    private Author author;
    private String title;
}
