package com.consumerConfig.spring.autoConfig.testAPI;

import com.spring.data.mongo.trackuser.DT.TrackUserDT;
import com.spring.data.mongo.trackuser.DT.service.TrackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class TestAPI {

    @Autowired
    private TrackUserService trackUserService;

    @GetMapping("/test")
    public Iterator<TrackUserDT> testAPI() {
        return trackUserService.getAllData();
    }

}
