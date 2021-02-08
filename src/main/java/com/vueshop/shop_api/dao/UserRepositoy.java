package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepositoy extends CrudRepository<User, Integer> {
    @Query(value = "select user_password from user where user_name = ?1",nativeQuery = true)
    String find(String username);
    @Query(value = "select * from user where user_name =?1",nativeQuery = true)
    User findAll(String username);
    @Query(value = "select id from user where user_name = ?1",nativeQuery = true)
    int findID(String username);
    @Query(value = "update id from user where user_name = ?1",nativeQuery = true)
    User updataUser(int id);
}
