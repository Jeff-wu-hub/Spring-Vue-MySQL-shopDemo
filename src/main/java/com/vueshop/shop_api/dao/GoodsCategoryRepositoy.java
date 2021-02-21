package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.GoodsCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;

public interface GoodsCategoryRepositoy extends CrudRepository<GoodsCategory,Integer> {
    @Query(value = "select * from goods_category",nativeQuery = true)
    List<HashMap<String,Object>> selectAll();
}
