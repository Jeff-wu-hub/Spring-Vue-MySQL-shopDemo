package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

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

    /**
     * 查询所有用户信息
     * @param page
     * @return Page<user></user>
     */
    @Query(value = "select * from user",nativeQuery = true)
    Page<User> selectAll(PageRequest page);

    @Query(value = "update user set online = ?2 where id = ?1",nativeQuery = true)
    void setUserOnline(int id,int type);

    @Query(value = "select * from user where name = ?1",nativeQuery = true)
    Page<User> selectUserName(String name, Pageable page);
}
