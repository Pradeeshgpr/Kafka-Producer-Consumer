package com.testKafka.consumer.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private static final String CONSUMER_TEST_URL = "";

    @PostMapping(path = CONSUMER_TEST_URL)
    public ResponseEntity testConsumer() {
        return ResponseEntity.ok().build();
    }

}
