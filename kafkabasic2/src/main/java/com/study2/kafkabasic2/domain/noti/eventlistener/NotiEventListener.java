package com.study2.kafkabasic2.domain.noti.eventlistener;

import com.study2.kafkabasic2.domain.noti.service.NotiService;
import com.study2.kafkabasic2.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {
    private final NotiService notiService;

    @EventListener
    @Async
    public void listen(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }

    @KafkaListener(topics = "chat-room-1", groupId = "1")
    public void consume(String message) {

        System.out.println("Consume message: " + message);
    }
    @KafkaListener(topics = "chat-room-1", groupId = "2")
    public void consume2(String message) {
        System.out.println("consume2 message: " + message);
    }
}
