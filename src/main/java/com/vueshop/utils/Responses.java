package com.vueshop.utils;



import com.vueshop.shop_api.code.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//返回状态码和数据库中查询的数据
@Component
public class Responses {

    @Autowired
    Meta meta;
    int code;
    String msg;
    public HashMap<String,Object> init(HttpServletRequest request, HashMap<String, Object> result) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("data",result);
        return map;
    }
}
