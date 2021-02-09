package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.shop_api.entity.User;
import com.vueshop.shop_api.service.UserService;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
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
     * 使用用户名称、密码进行登录
     *
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, Object> getOrder(HttpServletRequest request,
                                            @RequestParam(value = "username", required = false) String username,
                                            @RequestParam(value = "password", required = false) String password) {
        HashMap<String, Object> result = userService.login(username, password);
        return responses.init(request, result);
    }

    /**
     * 增加用户
     *
     * @param request
     * @param username
     * @param password
     * @param email
     * @param address
     * @param phone
     * @param money
     * @param name
     * @return
     */
    @PostMapping("/user/addUser")
    @ResponseBody
    public HashMap<String, Object> addUser(HttpServletRequest request,
                                              @RequestParam(value = "username", required = false) String username,
                                              @RequestParam(value = "password", required = false) String password,
                                              @RequestParam(value = "email", required = false) String email,
                                              @RequestParam(value = "address", required = false) String address,
                                              @RequestParam(value = "phone", required = false) String phone,
                                              @RequestParam(value = "money", required = false, defaultValue = "0") int money,
                                              @RequestParam(value = "name", required = false) String name) {
        HashMap<String, Object> result = userService.addUser(username, password, email, address, phone, money, name);
        return responses.init(request, result);
    }

    /**
     * 根据ID删除用户
     * @param request
     * @param id
     * @return HASHMap
     */
    @PostMapping("/user/deleteUser")
    @ResponseBody
    public HashMap<String,Object> deleteUser(HttpServletRequest request,
                                             @RequestParam(value = "id", required = false) int id){
        HashMap<String,Object> result = userService.deleteUser(id);
        return responses.init(request,result);
    }
    /**
     * 更改用户信息
     *
     * @param request
     * @param id
     * @param username
     * @param password
     * @param email
     * @param address
     * @param phone
     * @param money
     * @param name
     * @return
     */
    @PostMapping("/user/updateUser")
    @ResponseBody
    public HashMap<String, Object> updateUser(HttpServletRequest request,
                                              @RequestParam(value = "id", required = false) int id,
                                              @RequestParam(value = "username", required = false) String username,
                                              @RequestParam(value = "password", required = false) String password,
                                              @RequestParam(value = "email", required = false) String email,
                                              @RequestParam(value = "address", required = false) String address,
                                              @RequestParam(value = "phone", required = false) String phone,
                                              @RequestParam(value = "money", required = false, defaultValue = "0") int money,
                                              @RequestParam(value = "name", required = false) String name
    ) {
        HashMap<String, Object> result = userService.updateUser(id, username, password, email, address, phone, money, name);
        return responses.init(request, result);
    }
//    @GetMapping("/user/selectUser")
//    @ResponseBody
//    public HashMap<String, Object> selectUser(HttpServletRequest request,
//                                              @RequestParam(value = "id", required = false) int id,
//                                              @RequestParam(value = "username", required = false) String username,
//                                              @RequestParam(value = "password", required = false) String password,
//                                              @RequestParam(value = "email", required = false) String email,
//                                              @RequestParam(value = "address", required = false) String address,
//                                              @RequestParam(value = "phone", required = false) String phone,
//                                              @RequestParam(value = "money", required = false) int money,
//                                              @RequestParam(value = "name", required = false) String name){
//        HashMap<String ,Object> result = userService.selectAll(username,password,email,address,phone,money,name);
//        return responses.init(request,result);
//    }
}
