package com.vueshop.shop_api.service;

import com.vueshop.shop_api.code.Meta;
import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.shop_api.entity.User;
import com.vueshop.utils.Responses;
import org.apache.ibatis.jdbc.Null;
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
    HashMap<String, Object> result = new HashMap<>(); //定义数据库查询数据
    HashMap<String, Object> metaData = new HashMap<>(); //定义meta状态
    User tempData;//数据库查询内容
    User user = new User();

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     */
    public HashMap<String, Object> login(String username, String password) {
        init(SERVICE, 0, null);
        if (username == null || password == null) { //空参
            init(ERROR_PARAMS, 0, null);
            return result;
        }
        if (password.equals(userRepositoy.find(username))) {//比对数据
            List<Object> data = new ArrayList<>();
            data.add(userRepositoy.selectByUserName(username));
            init(SUCCESS, data.size(), data);

            return result;
        } else {
            init(ERROR, 0, null);
            return result;

        }

    }

    /**
     * 增加用户
     *
     * @param
     * @return
     */
    public HashMap<String, Object> addUser(String username, String password, String email, String address, String phone, int money, String name) {
        tempData = userRepositoy.selectByUserName(username);
        if (tempData == null) { //用户名不存在增加信息
            user.setUser_name(username);
            user.setUser_password(password);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            user.setMoney(money);
            user.setName(name);
            userRepositoy.save(user);
            init(SUCCESS_ADD_USER, 0, null);
        } else {
            //username重复，需要修改用户名
            init(ERROR_ADD_USER, 0, null);
        }
        return result;

    }

    /**
     * 删除用户
     * @param id
     * @return result
     */
    public HashMap<String,Object> deleteUser(int id){
        tempData = userRepositoy.selectById(id);
        if (tempData ==null){
            init(ERROR_DELETE_USER,0,null);
            return result;
        }else{
            userRepositoy.deleteById(id);
            init(SUCCESS_DELETE_USER,0,null);
            return result;
        }

    }
    /**
     * 更新用户信息
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
    public HashMap<String, Object> updateUser(int id, String username, String password, String email, String address, String phone, int money, String name) {
        tempData = userRepositoy.selectByUserName(username);
        if (tempData == null) { //如果用户名不重复
            user.setId(id);
            user.setUser_name(username);
            user.setUser_password(password);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            user.setMoney(money);
            user.setName(name);
            userRepositoy.save(user);
            init(SUCCESS_UPDATE_USER, 0, null);
            return result;
        }else{
            init(ERROR_UPDATE_USER, 0, null);
            return result;
        }
    }

//    public HashMap<String, Object> selectAll(String username, String password, String email, String address, String phone, int money, String name) {
//        userRepositoy.findAll(username,password,email,address,phone,money,name);
//        return metaData;
//    }

    /**
     * 返回给response
     *
     * @param code
     * @param total
     * @param data
     */
    public void init(int code, int total, List<Object> data) {
        metaData.put("code", code);
        metaData.put("msg", meta.getMsg(code));
        metaData.put("total", total);
        result.put("data", data);
        result.put("meta", metaData);
    }

}
