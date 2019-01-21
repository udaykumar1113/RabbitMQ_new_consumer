package com.uday.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MultipleConsumerService {
    @RabbitListener(queues = "com.uday.rapidProducerEventsQueue", concurrency = "3")
    public void consumeMessages(String message) throws InterruptedException {
        //Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+ " consuming message "+message);
    }
}
