package com.study2.kafkabasic2.domain.noti.service;

import com.study2.kafkabasic2.domain.noti.repository.NotiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotiService {
    private final NotiRepository notiRepository;
}
