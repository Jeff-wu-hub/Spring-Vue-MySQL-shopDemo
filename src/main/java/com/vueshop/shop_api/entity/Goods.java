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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getGoods_photo() {
        return goods_photo;
    }

    public void setGoods_photo(String goods_photo) {
        this.goods_photo = goods_photo;
    }

    public String getGoods_brand() {
        return goods_brand;
    }

    public void setGoods_brand(String goods_brand) {
        this.goods_brand = goods_brand;
    }

    public String getGoods_create_time() {
        return goods_create_time;
    }

    public void setGoods_create_time(String goods_create_time) {
        this.goods_create_time = goods_create_time;
    }
}
