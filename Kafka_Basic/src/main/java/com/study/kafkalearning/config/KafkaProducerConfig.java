package com.study.kafkalearning.config;
import org.apache.kafka.common.serialization.StringSerializer;
import com.study.kafkalearning.entity.MyMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    // 연결할 브로커의 서버 정보
    private static final String BOOTSTRAP_SERVER = "localhost:9092";
    @Bean
    public ProducerFactory<String,String> producerFactory(){

        Map<String,Object> configProps = new HashMap<>();

        //Required properties
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }
    /*
        메세지 발송 모듈에서 사용할 KafKaTemplate -> Message Publishing
     */

    @Bean
    public KafkaTemplate<String,String> kafakaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, MyMessage> newProducerFactory(){// value 타입으로 DTO - MyMessage()
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String,MyMessage> newKafkaTemplate(){
        return new KafkaTemplate<>(newProducerFactory());
    }


}
