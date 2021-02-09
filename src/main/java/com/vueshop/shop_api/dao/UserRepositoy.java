package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoy<value> extends CrudRepository<User, Integer> {
    /**
     * 根据用户名查询密码
     *
     * @param username
     * @return String
     */
    @Query(value = "select user_password from user where user_name = ?1", nativeQuery = true)
    String find(String username);
    /**
     * 通过id查询数据库
     * @param id
     * @return user
     */
    @Query(value = "select * from user where id=?1", nativeQuery = true)
    User selectById(int id);
    /**
     * 根据用户名查询是否为空
     *
     * @param username
     * @return user
     */
    @Query(value = "select * from user where user_name =?1", nativeQuery = true)
    User selectByUserName(String username);

//    @Query(value = "select * from user where user_name = ?1 and user_password = ?2 and email = ?3 and address = 4? and phone = ?5 and money = ?6 and name = ?7",nativeQuery = true)
//    User findAll(String username, String password, String email, String address, String phone, int money, String name);
}
