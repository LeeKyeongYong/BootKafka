package com.study2.kafkabasic2.global.event;

import com.study2.kafkabasic2.domain.post.entity.Post;
import lombok.Getter;
import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;

@Getter
public class PostCreatedEvent  extends ApplicationEvent {
    private final Post post;

    public PostCreatedEvent(Object source, Post post) {
        super(source);
        this.post = post;
    }
}