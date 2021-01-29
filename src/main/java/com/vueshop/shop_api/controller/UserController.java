package com.vueshop.shop_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin//允许跨域
public class UserController {
    @PostMapping("/login")
    @ResponseBody
    public Object getOrder(@RequestParam("username") String userID,@RequestParam("password") String password){
        return userID + password;
    }
}
