package com.chrisxyq.vxmsgpush.dto.response;

import com.chrisxyq.vxmsgpush.dto.Forecast;
import com.chrisxyq.vxmsgpush.dto.Location;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponseResult {
    private Location       location;
    private List<Forecast> forecasts;
}
