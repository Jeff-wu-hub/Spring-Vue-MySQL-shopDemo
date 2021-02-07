package com.vueshop.shop_api.code;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.util.HashMap;


//枚举错误信息类型
@Component
public class Meta {

    HashMap<Integer, String> msg = new HashMap<>();//定义表示对应信息、

    public final static int SUCCESS = 200;//登陆成功
    public final static int ERROR = 400;//登录失败
    public final static int ERROR_PARAMS = 401;//传参错误
    public final static int SERVICE = 500;//服务器异常

    /**
     * 得到消息提示信息
     * @param code
     * @return
     */
    public String getMsg(Integer code){
        if(msg.isEmpty()){
            msgInit();
        }
        String result = msg.get(code);
        return result;
    }

    /**
     * 初始化表示对应信息Map表
     */
    public void msgInit(){
        msg.put(SUCCESS,"登录成功");
        msg.put(ERROR,"登录成功");
        msg.put(ERROR_PARAMS,"传参错误");
        msg.put(SERVICE,"服务器异常");
    }
}
