package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.code.Meta;
import com.vueshop.shop_api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@CrossOrigin//允许跨域
public class UserController {
    String username;
    String password;
    @Autowired
    LoginService loginService;
    Meta meta;
    @PostMapping("/login")
    @ResponseBody
    public Meta getOrder(@RequestParam Map<String, String> obj){
        username = obj.get("username");
        password = obj.get("password");
        if(loginService.getLogin(username,password)){
            System.out.println(meta);
           return meta.LOGIN_SUCCESS;
        }else{
            return meta.LOGIN_ERROR;
        }
    }

}
