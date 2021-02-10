package com.vueshop.shop_api.code;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.util.HashMap;


//枚举错误信息类型
@Component
public class Meta {
    /**
     * 1++成功
     * 4++失败
     * 5++错误
     * +1+增加
     * +2+修改
     * +3+删除
     */
    HashMap<Integer, String> msg = new HashMap<>();//定义表示对应信息、
    public final static int SUCCESS = 10;//登陆成功
    public final static int SUCCESS_SELECT = 100;//查询成功
    ///////////////////////////////////////////////////////////////////
    /**
     * 增加成功
     * 1（1）（功能）
     */
    public final static int SUCCESS_ADD = 110;//增加成功

    /**
     * 更改成功
     * 1（2）（功能）
     */
    public final static int SUCCESS_UPDATE = 120;//更新成功
    public final static int SUCCESS_UPDATE_USER_TYPE = 121;//修改用户状态成功
    /**
     * 删除成功
     * 1(3)（功能）
     */
    public final static int SUCCESS_DELETE = 130;//删除成功
    ////////////////////////////////////////////////////////////////////
    /**
     * 失败
     * 4（标识）（功能）
     */
    public final static int ERROR = 400;//登录失败
    public final static int ERROR_SELECT = 401;//查询失败
    /**
     * 增加失败
     * 4（1）（功能）
     */
    public final static int ERROR_ADD = 410;//添加失败
    /**
     * 修改失败
     * 4（2）（功能）
     */
    public final static int ERROR_UPDATE = 420;//修改信息失败
    public final static int ERROR_UPDATE_USER_TYPE = 421;//修改状态失败
    /**
     * 删除失败
     * 4（3）（功能）
     */
    public final static int ERROR_DELETE = 430;//删除失败

    ///////////////////////////////////////////////////////////////////
    public final static int SERVICE = 500;//服务器异常
    public final static int ERROR_PARAMS = 501;//传参错误


    /**
     * 得到消息提示信息
     *
     * @param code
     * @return
     */
    public String getMsg(Integer code) {
        if (msg.isEmpty()) {
            msgInit();
        }
        String result = msg.get(code);
        return result;
    }

    /**
     * 初始化表示对应信息Map表
     */
    public void msgInit() {
        msg.put(SUCCESS, "登录成功");
        msg.put(ERROR, "账号或密码错误");
        msg.put(ERROR_PARAMS, "传参错误");
        msg.put(SERVICE, "服务器异常");
        msg.put(ERROR_ADD, "添加失败");
        msg.put(SUCCESS_ADD, "添加成功");
        msg.put(SUCCESS_UPDATE, "修改成功");
        msg.put(SUCCESS_SELECT, "查询信息成功");
        msg.put(SUCCESS_DELETE, "删除成功");
        msg.put(ERROR_SELECT, "没有数据");
        msg.put(ERROR_UPDATE, "修改失败");
        msg.put(ERROR_DELETE, "删除失败");
        msg.put(ERROR_UPDATE_USER_TYPE, "修改状态失败");
        msg.put(SUCCESS_UPDATE_USER_TYPE, "修改状态成功");
    }
}
