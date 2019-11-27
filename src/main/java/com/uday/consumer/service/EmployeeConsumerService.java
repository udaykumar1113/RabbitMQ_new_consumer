package com.uday.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.consumer.Employee.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeConsumerService {

    @RabbitListener(queues = "com.uday.employeeQueue")
    public void getEmployeesJson(String message) throws IOException {
        Employee employee=new ObjectMapper().readValue(message, Employee.class);
        System.out.println("The read employee message is "+employee.getEmployeeName());
    }
}
