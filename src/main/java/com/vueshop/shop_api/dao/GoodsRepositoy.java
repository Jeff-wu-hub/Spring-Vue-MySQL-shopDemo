package com.vueshop.shop_api.dao;

import com.vueshop.shop_api.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface GoodsRepositoy extends JpaRepository<Goods,Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert goods (id,goods_name,goods_type,goods_detail,goods_phone,goods_brand,goods_create_time) value (?1,?2,?3,?4,?5,?6,?7) on duplicate key update id=?1,goods_name=?2,goods_type=?3,goods_detail=?4,goods_phone=?5,goods_brand=?6,goods_create_time=?7",nativeQuery = true)
    void insertGoods(String id,String s1,String s2,String s3,String s4,String s5,String s6  );

}
