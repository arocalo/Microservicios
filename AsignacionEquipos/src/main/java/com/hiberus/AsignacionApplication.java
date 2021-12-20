package com.hiberus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class AsignacionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsignacionApplication.class, args);
    }
}
