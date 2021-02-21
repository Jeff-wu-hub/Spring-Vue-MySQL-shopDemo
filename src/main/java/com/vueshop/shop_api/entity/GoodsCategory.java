package com.vueshop.shop_api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GoodsCategory {
    @Id
    private int cat_id;
    private String cat_name;
    private int cat_pid;
    private int cat_level;
    private int cat_deleted;
}
