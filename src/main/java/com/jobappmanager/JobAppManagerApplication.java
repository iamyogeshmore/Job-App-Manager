package com.jobappmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobAppManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobAppManagerApplication.class, args);
        System.out.println("Welcome to Job app manager.");
    }

}
