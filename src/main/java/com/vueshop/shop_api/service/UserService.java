package com.vueshop.shop_api.service;

import com.vueshop.shop_api.code.Meta;
import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.vueshop.shop_api.code.Meta.*;

@Service
public class UserService {

    @Autowired
    UserRepositoy userRepositoy;
    @Autowired
    Responses responses;
    @Autowired
    Meta meta;
    HashMap<String,Object> result = new HashMap<>(); //定义数据库查询数据
    HashMap<String,Object> metaData = new HashMap<>(); //定义meta状态
    public HashMap<String,Object> getLogin(String username, String password){
        init(SERVICE,meta.getMsg(SERVICE),0,null);
        if(username.equals("") || password.equals("")){ //空参
            init(ERROR_PARAMS,meta.getMsg(ERROR_PARAMS),0,null);
            return result;
        }
        if(password.equals(userRepositoy.find(username))){//比对数据
            List<Object> data = new ArrayList<>();
            data.add(userRepositoy.findAll(username));
            init(SUCCESS,meta.getMsg(SUCCESS),data.size(),data);

            return result;
        }else{
            init(ERROR,meta.getMsg(ERROR),0,null);
            return result;

        }

    }

    /**
     * 放回数据
     * @param code
     * @param msg
     */
    public void init(int code,String msg,int total,List<Object> data){
        metaData.put("code",code);
        metaData.put("msg",msg);
        metaData.put("total",total);
        result.put("data",data);
        result.put("meta",metaData);
    }

}
