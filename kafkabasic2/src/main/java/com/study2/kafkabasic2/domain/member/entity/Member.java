package com.study2.kafkabasic2.domain.member.entity;


import com.study2.kafkabasic2.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;
@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Member extends BaseTime {
    @Column(unique = true)
    private String username;
    private String password;
    private String nickname;
    @Setter(PRIVATE)
    private long postsCount;
    public void increasePostCount(){
        postsCount++;
    }
}
