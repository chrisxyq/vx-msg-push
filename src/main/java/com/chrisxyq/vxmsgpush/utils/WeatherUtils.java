package com.chrisxyq.vxmsgpush.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.chrisxyq.vxmsgpush.dto.response.WeatherResponse;
import org.junit.Test;

public class WeatherUtils {
    private static final String URL = "https://api.map.baidu.com/weather/v1/?district_id=%s&data_type=%s&ak=%s";
    /**
     * todo:自己应用的ak 需修改
     */
    private static final String AK  = "";

    /**
     * 所在地行政代码 市 需修改
     *
     * @param regionCode
     * @return
     */
    public static WeatherResponse getWeather(String regionCode) {
        String result = HttpUtil.get(String.format(URL, regionCode, "all", AK));
        return JSONUtil.toBean(result, WeatherResponse.class);
    }

    @Test
    public void test() {
        WeatherUtils.getWeather("310110");
    }

}
