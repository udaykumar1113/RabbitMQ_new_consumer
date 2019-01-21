package com.uday.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MarketingConsumerService {

    @RabbitListener(queues = "x.hr.marketing")
    public void consumeMarketingMessages(String message){
        System.out.println("Consuming message from marketing queue: "+message);
    }
}
