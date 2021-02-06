package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoy extends CrudRepository<User, List> {
    @Query(value = "select user_password from user where user_name = ?1",nativeQuery = true)
    String  find(String username);
}
