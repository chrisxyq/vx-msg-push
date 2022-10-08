package com.chrisxyq.vxmsgpush;

import com.chrisxyq.vxmsgpush.dto.WeatherMessageConfigInfo;
import com.chrisxyq.vxmsgpush.service.WeatherMessageService;
import com.chrisxyq.vxmsgpush.utils.WeatherMessageConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;


@SpringBootApplication
@EnableScheduling
public class VxLoveletterApplication {
    @Autowired
    WeatherMessageService weatherMessageService;

    public static void main(String[] args) {
        SpringApplication.run(VxLoveletterApplication.class, args);
    }


    @Scheduled(cron = "0 30 8 * * ?")
    public void weatherMessageSend() {
        com.chrisxyq.vxmsgpush.dto.WeatherMessageConfig config = WeatherMessageConfigProvider.config;
        if (config != null && !CollectionUtils.isEmpty(config.getConfigInfoList())) {
            for (WeatherMessageConfigInfo configInfo : config.getConfigInfoList()) {
                weatherMessageService.sendMessage(configInfo);
            }
        }
    }
}
