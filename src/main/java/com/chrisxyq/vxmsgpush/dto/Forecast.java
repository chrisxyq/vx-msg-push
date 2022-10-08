package com.chrisxyq.vxmsgpush.dto;

import lombok.Data;

@Data
public class Forecast {
    private String text_day;
    private String text_night;
    private String high;
    private String low;
    private String wc_day;
    private String wd_day;
    private String wc_night;
    private String wd_night;
    private String date;
    private String week;

}
