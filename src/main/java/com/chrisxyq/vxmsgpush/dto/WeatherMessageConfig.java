package com.chrisxyq.vxmsgpush.dto;

import lombok.Data;

import java.util.List;

@Data
public class WeatherMessageConfig {
    private List<WeatherMessageConfigInfo> configInfoList;
}
