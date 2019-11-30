package com.duwojian.hybrid_controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.duwojian.controller")
public class HybridControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HybridControllerApplication.class, args);
    }

}
