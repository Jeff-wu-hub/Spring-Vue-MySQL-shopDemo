package com.vueshop.shop_api.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private int id;
    private String user_name;
    private String user_password;
    private int online;
    private String email;
    private String address;
    private String phone;
    private int level;
    private int money;
    private String create_time;
    private String name;

}
