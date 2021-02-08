package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.shop_api.entity.User;
import com.vueshop.shop_api.service.UserService;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
@CrossOrigin//允许跨域
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
     Responses responses;
    @Autowired
    UserRepositoy userRepositoy;


    /**
     *
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,Object> getOrder(HttpServletRequest request,
                              @RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password) {
        HashMap<String,Object> result = userService.getLogin(username,password);
        return responses.init(request,result);
    }
    @PostMapping("/user/adduser")
    @ResponseBody
    public HashMap<String,Object> userInser(HttpServletRequest request,
                                            @RequestParam(value = "username",required = false) String username,
                                            @RequestParam(value = "password",required = false) String password,
                                            @RequestParam(value = "email",required = false) String email,
                                            @RequestParam(value = "address",required = false) String address,
                                            @RequestParam(value = "phone",required = false) String phone,
                                            @RequestParam(value = "money",required = false) int money,
                                            @RequestParam(value = "name",required = false) String name) {
        HashMap<String,Object> result = userService.addUser(username,password,email,address,phone,money,name);
        return responses.init(request,result);
    }

}
