package com.hiberus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class EvolucionApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvolucionApplication.class, args);
    }
}
