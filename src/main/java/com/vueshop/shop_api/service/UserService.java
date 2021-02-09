package com.vueshop.shop_api.service;

import com.vueshop.shop_api.code.Meta;
import com.vueshop.shop_api.dao.UserRepositoy;
import com.vueshop.shop_api.entity.User;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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


    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     */
    public HashMap<String, Object> login(String username, String password) {
        init(SERVICE, null);
        if (username == null || password == null) { //空参
            init(ERROR_PARAMS, null);
            return result;
        }
        if (password.equals(userRepositoy.find(username))) {//比对数据
            tempData = userRepositoy.selectByUserName(username);
            init(SUCCESS,null );
            return result;
        } else {
            init(ERROR ,null);
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
        if (userRepositoy.selectByUserName(username) == null) { //用户名不存在增加信息
            User user = new User();
            user.setUser_name(username);
            user.setUser_password(password);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            user.setMoney(money);
            user.setName(name);
            userRepositoy.save(user);
            init(SUCCESS_ADD, null);
        } else {
            //username重复，需要修改用户名
            init(ERROR_ADD, null);
        }
        return result;

    }

    /**
     * 删除用户
     * @param id
     * @return result
     */
    public HashMap<String,Object> deleteUser(int id){
        System.out.println(userRepositoy.selectById(id));
        if (userRepositoy.selectById(id) ==null){
            init(ERROR_DELETE,null);
            return result;
        }else{
            userRepositoy.deleteById(id);
            init(SUCCESS_DELETE,null);
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
        User user = new User();
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
            init(SUCCESS_UPDATE, null);
            return result;
        }else{
            init(ERROR_UPDATE, null);
            return result;
        }
    }

    /**
     * 查询所有数据
     * @return meta状态+数据
     */
    public HashMap<String, Object> selectAll(int currentPage, int pageSize) {
        PageRequest page =  PageRequest.of(currentPage,pageSize);
        init(SUCCESS_SELECT, userRepositoy.selectAll(page));
        return result;
    }

    /**
     * 改变用户状态
     * @param id
     * @param type
     * @return result
     */
    public HashMap<String,Object> changeType(int id, int type){
        tempData = userRepositoy.selectById(id);
        User user = new User();
        if(tempData == null){
            init(ERROR_UPDATE_USER_TYPE,null);
            return result;
        }else{
            user.setUserOnline(id,type);
            userRepositoy.save(user);
            init(SUCCESS_UPDATE_USER_TYPE,null);
        }
        return result;
    }

    /**
     * 查询用户名字
     * @param name
     * @return
     */
    public HashMap<String, Object> selectUserName(String name,int page,int pageSize) {
        PageRequest Page = PageRequest.of(page,pageSize);
        Page<User> Data = userRepositoy.selectUserName(name,Page);
        if(Data.getTotalElements() == 0){
            init(ERROR_SELECT,null);
            return result;
        }else{
            init(SUCCESS_SELECT,Data);
            return result;
        }
    }
    /**
     * 返回给response
     *  @param code
     * @param data
     */
    public void init(int code, Page data) {
        metaData.put("code", code);
        metaData.put("msg", meta.getMsg(code));
        result.put("data", data);
        result.put("meta", metaData);
    }


}
