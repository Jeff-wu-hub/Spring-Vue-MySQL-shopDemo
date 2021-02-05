package com.vueshop.shop_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class UserList {
    @GetMapping("user")
    @ResponseBody
    public Object getUserList(@RequestBody Object object){
        return object;
    }
}
