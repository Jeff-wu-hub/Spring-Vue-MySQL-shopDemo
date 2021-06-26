package com.vueshop.shop_api.error;

import java.util.Map;

public class CommonReturnType {
    //返回错误码
    private String code;

    //表明对应请求的返回处理结果:success fail
    private String status;

    //当status为success时，则返回前端所需要的数据
    private Object data;

    public CommonReturnType(String code, String status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", status:'" + status + '\'' +
                ", data:" + data +
                '}';
    }
}

