package com.study2.kafkabasic2.domain.noti.entity;

import com.study2.kafkabasic2.domain.member.entity.Member;
import com.study2.kafkabasic2.global.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Noti extends BaseTime {
    @ManyToOne
    private Member actor;
    @ManyToOne
    private Member receiver;
    private String relTypeCode;
    private long relId;
    private String typeCode;
    private String type2Code;
    private boolean read;
}