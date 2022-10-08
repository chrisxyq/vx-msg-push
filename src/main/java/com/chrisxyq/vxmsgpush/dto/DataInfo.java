package com.chrisxyq.vxmsgpush.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送模板消息
 * 的消息内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataInfo {

    private String value;

    private String color;

    public DataInfo(String value) {
        this.value = value;
        //this.color="#FFCCCC";
    }
}