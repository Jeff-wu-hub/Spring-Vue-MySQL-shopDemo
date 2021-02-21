package com.vueshop.shop_api.service;

import com.vueshop.shop_api.code.Meta;
import com.vueshop.shop_api.dao.GoodsCategoryRepositoy;
import com.vueshop.shop_api.entity.GoodsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsCategoryService {
    @Autowired
    GoodsCategoryRepositoy goodsCategoryRepositoy;
    @Autowired
    Meta meta;
    HashMap<String, Object> result = new HashMap<>(); //定义数据库查询数据
    HashMap<String, Object> metaData = new HashMap<>(); //定义meta状态
    GoodsCategory temp;// 数据库临时查询数据


    public HashMap<String ,Object> selectAll(){
        List<HashMap<String,Object>> data = goodsCategoryRepositoy.selectAll();
        init(meta.SUCCESS_SELECT,data);7
        return result;
    }

    /**
     * 返回给response
     *  @param code
     */
    public void init(int code, List<HashMap<String,Object>> data) {
        metaData.put("code", code);
        metaData.put("msg", meta.getMsg(code));
        result.put("data", data);
        result.put("meta", metaData);
    }
}
