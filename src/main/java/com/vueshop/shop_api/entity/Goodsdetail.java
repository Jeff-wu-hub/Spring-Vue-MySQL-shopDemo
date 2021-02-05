package com.vueshop.shop_api.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
public class Goodsdetail {
    private int detail_id;
    private String detail_name;
    private int goods_id;
    private Long prince;
    private String photo;
}
