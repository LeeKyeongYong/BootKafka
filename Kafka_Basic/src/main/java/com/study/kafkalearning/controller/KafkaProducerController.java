package com.study.kafkalearning.controller;

import com.study.kafkalearning.entity.MyMessage;
import com.study.kafkalearning.service.KafakaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafakaProducerService kafakaProducerService;

    @GetMapping("/publish")
    public String publish(String message){
        kafakaProducerService.send(message);
        return "published a message: "+message;
    }

    @GetMapping("/publish2")
    public String publishWithCallback(String message){
        kafakaProducerService.sendWithCallback(message);
        return "published a message with callback: "+message;
    }


    @GetMapping("/publish3")
    public String publishJson(MyMessage message){
        kafakaProducerService.sendJson(message);
        return "published a message to Json: "+message.getName()+" , "+message.getMessage();
    }
}
