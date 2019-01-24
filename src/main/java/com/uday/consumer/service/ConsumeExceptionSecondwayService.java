package com.uday.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.consumer.Employee.Picture;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

@Service
public class ConsumeExceptionSecondwayService {

    ObjectMapper objectMapper=new ObjectMapper();
    @RabbitListener(queues = "q.mypicture.image")
    public void consumeExceptionSecondway(Message message, Channel channel) throws IOException {
        Picture picture=objectMapper.readValue(message.getBody(),Picture.class);
        if(picture.getSize()>9000){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        }
        else{
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }
    }
}
