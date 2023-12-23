package com.study.kafkalearning.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyMessage { //ObjectMapper객체에 매핑이 제대로 이러워지기위해서 정의되어야함.
    private String name;
    private String message;
}
