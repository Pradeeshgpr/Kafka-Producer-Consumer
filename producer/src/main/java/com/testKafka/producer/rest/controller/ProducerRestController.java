package com.testKafka.producer.rest.controller;

import com.testKafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerRestController {

    private static final String PRODUCER_CONTROLLER_TEST = "/producer/test";

    @Autowired
    ProducerService producerService;

    @GetMapping(path = PRODUCER_CONTROLLER_TEST)
    public ResponseEntity testProducer() {
        try {
            producerService.sendTestMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
