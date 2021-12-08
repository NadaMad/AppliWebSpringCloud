package com.example.gpslabspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GpsLabSpringBootApplication {
    private final Logger logger = LoggerFactory.getLogger(GpsLabSpringBootApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(GpsLabSpringBootApplication.class, args);
    }


}