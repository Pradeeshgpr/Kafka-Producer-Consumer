package com.consumerConfig.spring.autoConfig.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.consumerConfig.spring.autoConfig",
        "com.spring.data.mongo"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
