package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.GoodsCategory;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepositoy extends CrudRepository<GoodsCategory,Integer> {

}
