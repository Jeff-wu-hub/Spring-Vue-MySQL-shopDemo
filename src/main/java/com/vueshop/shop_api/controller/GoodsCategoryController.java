package com.vueshop.shop_api.controller;

import com.vueshop.shop_api.service.GoodsCategoryService;
import com.vueshop.utils.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@Controller
@CrossOrigin
public class GoodsCategoryController {
    @Autowired
    Responses responses;
    @Autowired
    GoodsCategoryService goodsCategoryService;

    @GetMapping("/goods/getCategory")
    @ResponseBody
    public HashMap<String,Object> getCateGory(HttpServletRequest httpServletRequest){
        HashMap<String,Object> result = goodsCategoryService.selectAll();
        return responses.init(httpServletRequest,result);
    }
}
