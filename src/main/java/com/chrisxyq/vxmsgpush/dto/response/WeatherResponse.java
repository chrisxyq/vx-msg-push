package com.chrisxyq.vxmsgpush.dto.response;

import lombok.Data;

@Data
public class WeatherResponse {
    private String status;
    private WeatherResponseResult result;
    private String message;
}
