package com.vueshop.shop_api.code;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public enum Meta {
    LOGIN_SUCCESS(0,"登录成功！"),
    LOGIN_ERROR(1,"登陆失败！");

     int code;
     String msg;

      Meta(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
