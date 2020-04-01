package com.springboot.service;

import com.springboot.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.model.Student;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class KafkaReciever {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);
    @Autowired
    RestTemplate restTemplate;

    @Value("${emp.api.url}")
    private String EMP_URL;

    @KafkaListener(topics = "${kafka.topic.name}", group = "${kafka.consumer.group.id}")
    public void recieveData(Employee emp) {

        LOGGER.info("Data - " + emp.toString() + " recieved");
        try {
            String response = restTemplate.postForObject(EMP_URL, emp, String.class);
            LOGGER.info("Consumer Response " + response);
            System.out.println();
        } catch (RestClientException e) {
            LOGGER.error("Error calling Employee API");
        }
    }
}
