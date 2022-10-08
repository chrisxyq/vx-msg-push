package com.chrisxyq.vxmsgpush.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.chrisxyq.vxmsgpush.dto.TokenInfo;


public class VxUtil {
    /**
     * todo：改成 测试号信息APP_ID
     */
    private static final String APP_ID           = "";
    /**
     * todo：改成 测试号信息APP_SECRET
     */
    private static final String APP_SECRET       = "";
    /**
     * 获取Access token接口访问地址
     */
    private static final String TOKEN_URL        = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    /**
     * 发送模板消息接口
     */
    private static final String PUSH_URL         = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    /**
     * 获取Access token
     * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
     *
     * @return
     */
    public static TokenInfo getToken() {
        String result = HttpUtil.get(String.format(TOKEN_URL, APP_ID, APP_SECRET));
        return JSONUtil.toBean(result, TokenInfo.class);
    }

    /**
     * 模板消息接口
     * 发送模板消息
     *
     * @param message
     */
    public static void sendMessage(String message) {
        TokenInfo token = getToken();
        String result = HttpUtil.post(String.format(PUSH_URL, token.getAccess_token()), message);
    }

}
