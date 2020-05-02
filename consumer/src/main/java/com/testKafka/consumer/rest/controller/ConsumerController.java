package com.testKafka.consumer.rest.controller;

import com.testKafka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private static final String CONSUMER_TEST_URL = "/consumer/test";

    @Autowired
    private ConsumerService consumerService;

    @GetMapping(path = CONSUMER_TEST_URL)
    public ResponseEntity testConsumer() {
        try {
            consumerService.testConsumer();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
