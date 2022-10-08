package com.chrisxyq.vxmsgpush.controller;

import com.chrisxyq.vxmsgpush.dto.WeatherMessageConfig;
import com.chrisxyq.vxmsgpush.dto.WeatherMessageConfigInfo;
import com.chrisxyq.vxmsgpush.service.WeatherMessageService;
import com.chrisxyq.vxmsgpush.utils.WeatherMessageConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    WeatherMessageService weatherMessageService;

    @RequestMapping("WeatherMessage")
    public void setWeChatMenuByConfig() {
        WeatherMessageConfig config = WeatherMessageConfigProvider.config;
        if (config != null && !CollectionUtils.isEmpty(config.getConfigInfoList())) {
            for (WeatherMessageConfigInfo configInfo : config.getConfigInfoList()) {
                weatherMessageService.sendMessage(configInfo);
            }
        }
    }
}
