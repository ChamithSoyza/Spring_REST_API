package com.cms.sampleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cms.sampleapi.model")
public class SampleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApiApplication.class, args);
    }

}
