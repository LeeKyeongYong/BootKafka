package com.study2.kafkabasic2.domain.noti.eventlistener;

import com.study2.kafkabasic2.domain.noti.service.NotiService;
import com.study2.kafkabasic2.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
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
}
