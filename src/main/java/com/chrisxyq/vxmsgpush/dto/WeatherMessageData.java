package com.chrisxyq.vxmsgpush.dto;

import lombok.Data;

@Data
public class WeatherMessageData {
    /**
     * 称呼
     */
    private DataInfo userName;
    /**
     * 地区
     */
    private DataInfo region;
    /**
     * 今天的天气
     */
    private DataInfo textToday;
    /**
     * 今天的温度
     */
    private DataInfo low;
    /**
     * 今天的温度
     */
    private DataInfo high;
    /**
     * 今天的风
     */
    private DataInfo wdToday;
    /**
     * 明天的天气
     */
    private DataInfo textTomorrow;
    /**
     * 在一起的第
     */
    private DataInfo holdDay;
}
