package com.chrisxyq.vxmsgpush.dto.request;

import lombok.Data;


/**
 * 发送模板消息
 * 请求体
 */
@Data
public class SendTemplateMessageRequest<T> {
    /**
     * 接收者openid
     */
    private String touser;
    /**
     * 模板ID
     */
    private String template_id;
    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;
    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private String miniprogram;
    /**
     * 所需跳转到的小程序appid（该小程序 appid 必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
     */
    private String appid;
    /**
     * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
     */
    private String pagepath;
    /**
     * 模板数据
     */
    //private HashMap<String, DataInfo> data;
    private T data;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color = "#FF0000";
    /**
     * 防重入id。对于同一个openid + client_msg_id,
     * 只发送一条消息,10分钟有效,超过10分钟不保证效果。若无防重入需求，可不填
     */
    private String client_msg_id ;
}
