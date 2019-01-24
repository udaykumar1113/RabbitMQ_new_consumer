package com.uday.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.consumer.Employee.Picture;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumeExceptionService {

    ObjectMapper objectMapper=new ObjectMapper();

    //@RabbitListener(queues = "q.mypicture.image")
    public void consumeException(String message) throws IOException {
        Picture picture=objectMapper.readValue(message, Picture.class);
        if(picture.getSize()>=9000) {
                throw new AmqpRejectAndDontRequeueException("Picture size too large");
        }
        else {
            System.out.println(message);
        }
    }
}
