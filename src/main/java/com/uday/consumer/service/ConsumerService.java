package com.uday.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsumerService {

    @RabbitListener(queues = "com.uday.producerEventsQueue")
    public void consumeMessage(String message){
        System.out.println("Consuming message "+message+" at: "+ LocalDateTime.now());
    }
}
