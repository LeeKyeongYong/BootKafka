package com.study2.kafkabasic2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class Kafkabasic2Application {

    public static void main(String[] args) {
        SpringApplication.run(Kafkabasic2Application.class, args);
    }

}
