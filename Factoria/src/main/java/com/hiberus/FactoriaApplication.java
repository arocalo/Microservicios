package com.hiberus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class FactoriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FactoriaApplication.class, args);
    }
}
