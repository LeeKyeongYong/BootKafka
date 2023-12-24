package com.study.kafkalearning.service;

import com.study.kafkalearning.entity.MyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class KafakaProducerService {
    private static final String TOPIC_NAME ="dev-topic";

    private final KafkaTemplate<String,String> kafakaTemplate;

    private final KafkaTemplate<String, MyMessage> newKafkaTemplate;

    public void send(String message){
        kafakaTemplate.send(TOPIC_NAME,message);
    }

    public void sendWithCallback(String message) {
        CompletableFuture<SendResult<String, String>> future = kafakaTemplate.send(TOPIC_NAME, message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Failed publishing " + message + " due to " + ex.getMessage());
            } else {
                System.out.println("Success Sent " + message + " offset: " + result.getRecordMetadata().offset());
            }
        });
    }

    public void sendJson(MyMessage message){
        newKafkaTemplate.send(TOPIC_NAME,message);
    }

}
