package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.service.UserService;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@CrossOrigin//允许跨域
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
     Responses responses;

    /**
     *
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Responses getOrder(HttpServletRequest request,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        if(userService.getLogin(username, password)){
             responses.init(request,null);
        }
        System.out.println(responses);
        return responses;
    }

}
