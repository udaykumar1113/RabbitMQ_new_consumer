package com.uday.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.consumer.Employee.Picture;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DirectExchangeListenerService {

    @RabbitListener(queues = "q.picture.image")
    public void listenImages(String message) throws IOException {

        Picture picture=new ObjectMapper().readValue(message,Picture.class);
        System.out.println("message from image queue "+picture.getName());
    }

    @RabbitListener(queues = "q.picture.vector")
    public void listenVector(String message) throws IOException {

        Picture picture=new ObjectMapper().readValue(message,Picture.class);
        System.out.println("message from vector queue "+picture.getName());
    }

}
