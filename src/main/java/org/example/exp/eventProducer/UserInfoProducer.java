package org.example.exp.eventProducer;


import org.example.exp.model.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProducer {

    private final KafkaTemplate<String, UserInfoDto> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")

    @Autowired
    UserInfoProducer(KafkaTemplate<String,UserInfoDto> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
}
