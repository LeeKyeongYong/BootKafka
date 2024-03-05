package com.study2.kafkabasic2.domain.noti.eventlistener;

import com.study2.kafkabasic2.domain.noti.service.NotiService;
import com.study2.kafkabasic2.global.dto.chat.ChatMessageDto;
import com.study2.kafkabasic2.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor

public class NotiEventListener {
    private final NotiService notiService;

    @EventListener
    @Async
    public void listen(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }

    @KafkaListener(topics = "chat-room-1", groupId = "1")
    public void consume(ChatMessageDto  message) {

        System.out.println("Consume message: " + message);
    }
    @KafkaListener(topics = "chat-room-1", groupId = "2")
    public void consume2(ChatMessageDto message) {
        System.out.println("consume2 message: " + message);
    }
    @KafkaListener(topics = "chat-room-1.DLT", groupId = "1")
    public void consumeChatRoom1DLT(byte[] in) {
        String message = new String(in);
        System.out.println("failed message: " + message);
    }
}
