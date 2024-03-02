package com.study2.kafkabasic2.domain.noti.repository;

import com.study2.kafkabasic2.domain.noti.entity.Noti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotiRepository  extends JpaRepository<Noti, Long> {
}
