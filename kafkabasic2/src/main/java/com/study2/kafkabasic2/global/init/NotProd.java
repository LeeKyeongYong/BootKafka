package com.study2.kafkabasic2.global.init;


import com.study2.kafkabasic2.domain.member.entity.Member;
import com.study2.kafkabasic2.domain.member.service.MemberService;
import com.study2.kafkabasic2.domain.post.author.service.AuthorService;
import com.study2.kafkabasic2.domain.post.entity.Post;
import com.study2.kafkabasic2.domain.post.service.PostService;
import com.study2.kafkabasic2.domain.post.author.entity.Author;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
@Slf4j
@RequiredArgsConstructor
public class NotProd {

    @Autowired
    @Lazy
    private NotProd self;
    private final AuthorService authorService;
    private final MemberService memberService;
    private final PostService postService;

    @Bean
    @Order(3)
    public ApplicationRunner initNotProd(){
        return args->{
            if (memberService.count() > 0) return;
            self.work1();
            self.work2();
            self.work3();
        };
    }

    @Transactional
    public void work1(){
        Member memberUser1 = memberService.join("user1", "1234", "유저1").getData();
        Member memberUser2 = memberService.join("user2", "1234", "유저2").getData();
        Member memberUser3 = memberService.join("user3", "1234", "유저3").getData();

        Author author1 = postService.of(memberUser1);
        Author author2 = postService.of(memberUser2);

        Post post1 = postService.write(author1, "제목1").getData();
        Post post2 = postService.write(author2, "제목2").getData();
    }
    @Transactional
    public void work2() {
        Author author1 = authorService.findById(1).get();
        Author author2 = authorService.findById(2).get();
        Post post1 = postService.write(author1, "제목1").getData();
        Post post2 = postService.write(author2, "제목2").getData();
    }
    @Transactional
    public void work3() {
        Author author3 = authorService.findById(3).get();
        Post post3 = postService.write(author3, "제목3").getData();
    }
}
