package com.vueshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ShopApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApiApplication.class, args);
        System.out.printf("chen");
    }

}
