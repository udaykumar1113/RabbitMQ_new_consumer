package com.uday.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AccountingConsumerService {
    @RabbitListener(queues = "x.hr.accounting")
    public void consumeAccontingMessages(String message){
        System.out.println("Consuming message from accounting queue "+message);
    }
}
