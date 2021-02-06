package com.vueshop.shop_api.service;

import com.vueshop.shop_api.dao.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepositoy userRepositoy;
    public  Boolean  getLogin(String username,String password){
        if(password.equals(userRepositoy.find(username))){
            return true;
        }else{
            return false;
        }

    }
}
