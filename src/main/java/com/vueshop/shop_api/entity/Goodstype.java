package com.vueshop.shop_api.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Goodstype {
    @Id
    private int goods_id;
    private int id;
    private String type_name;
    private String type_plus;
}
