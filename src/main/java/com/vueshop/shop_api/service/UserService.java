package com.vueshop.shop_api.service;

import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepositoy userRepositoy;
    @Autowired
    Responses responses;

    public Boolean getLogin(String username, String password)throws Exception{
        String newpassword = userRepositoy.find(username);
        if(newpassword.equals(password)){
            return true;
        }else{
            return false;
        }
    }


}
