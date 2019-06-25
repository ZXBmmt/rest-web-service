package com.mmt.web.sample.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mmt"})
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
    }
}
