package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.dao.GoodsRepositoy;
import com.vueshop.shop_api.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin//允许跨域
public class GoodsController {
    @Autowired
    GoodsRepositoy goodsRepositoy;

    @GetMapping(value = "/in")
    @ResponseBody
    public String get(){
        return "hello";
    }

    @PostMapping(value = "/postgoods")//,produces = "application/json")
    @ResponseBody
    public String postGoods(Goods goods){
        goodsRepositoy.save(goods);
        return "成功";
    }

}
