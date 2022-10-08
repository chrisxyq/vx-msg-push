package com.chrisxyq.vxmsgpush.utils;

import cn.hutool.json.JSONUtil;
import com.chrisxyq.vxmsgpush.dto.WeatherMessageConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;

@Component
public class WeatherMessageConfigProvider {
    public static WeatherMessageConfig config = new WeatherMessageConfig();

    @Value("classpath:WeatherMessageConfig.json")
    private Resource userResource;

    @PostConstruct
    public WeatherMessageConfig getWeatherMessageConfig() {
        try {
            String json = IOUtils.toString(userResource.getInputStream(), Charset.forName("UTF-8"));
            config = JSONUtil.toBean(json, WeatherMessageConfig.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return config;
    }

}
