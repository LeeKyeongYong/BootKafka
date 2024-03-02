package com.study2.kafkabasic2.domain.member.repository;

import com.study2.kafkabasic2.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public class MemberRepository extends JpaRepository<Member,Long> {
}
