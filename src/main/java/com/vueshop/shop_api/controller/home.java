package com.vueshop.shop_api.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class home {
    @GetMapping("/home")
    public String home(){
        return "hello world";
    }
}
