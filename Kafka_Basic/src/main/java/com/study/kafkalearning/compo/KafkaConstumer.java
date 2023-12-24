package com.study.kafkalearning.compo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.kafkalearning.entity.MyMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConstumer {

    private static final String TOPIC_NAME="dev-topic";

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME) //해당 어노테이션이 적용된 메소드로 메세지를 수신한다.
    public void listMessage(String jsonMessage){
        try{
            MyMessage message = objectMapper.readValue(jsonMessage, MyMessage.class);
            System.out.println(">>>"+message.getName()+","+message.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
