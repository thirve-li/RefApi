package com.liri.reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ReferenceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ReferenceApplication.class, args);
    }
    
}
