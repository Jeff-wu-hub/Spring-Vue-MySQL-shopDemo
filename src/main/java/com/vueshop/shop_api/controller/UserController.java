package com.vueshop.shop_api.controller;

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
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        HashMap<String,Object> result = userService.getLogin(username,password);
        return responses.init(request,result);
    }

}
