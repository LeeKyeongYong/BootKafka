package com.study.kafkalearning.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerConfig {

    // 연결할 브로커의 서버 정보
    private static final String BOOTSTRAP_SERVER = "localhost:9092";
    @Bean
    public ProducerFactory<String,String> producerFactory(){

        Map<String,Object> configProps = new HashMap<>();

        //Required properties
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }
    /*
        메세지 발송 모듈에서 사용할 KafKaTemplate -> Message Publishing
     */

    

}
