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
    private boolean readStatus;

    public String getRelUrl() {
        if ("POST".equals(typeCode) && "CREATED".equals(type2Code)) {
            return "/p/" + relId;
        }

        return "";
    }

    public String getMessage() {
        if ("POST".equals(typeCode) && "CREATED".equals(type2Code)) {
            return actor.getNickname() + "님이 " + relId + "번글을 작성했습니다.";
        }

        return "";
    }
}