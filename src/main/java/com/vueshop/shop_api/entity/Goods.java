package com.vueshop.shop_api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Goods {
    @Id
    private String id;
    private String goods_name;
    private String goods_type;
    private String goods_detail;
    private String goods_photo;
    private String goods_brand;
    private String goods_create_time;

}
