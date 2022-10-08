package com.chrisxyq.vxmsgpush.service;

import cn.hutool.json.JSONUtil;
import com.chrisxyq.vxmsgpush.dto.DataInfo;
import com.chrisxyq.vxmsgpush.dto.WeatherMessageConfigInfo;
import com.chrisxyq.vxmsgpush.dto.WeatherMessageData;
import com.chrisxyq.vxmsgpush.dto.request.SendTemplateMessageRequest;
import com.chrisxyq.vxmsgpush.dto.response.WeatherResponse;
import com.chrisxyq.vxmsgpush.dto.response.WeatherResponseResult;
import com.chrisxyq.vxmsgpush.utils.DateUtil;
import com.chrisxyq.vxmsgpush.utils.VxUtil;
import com.chrisxyq.vxmsgpush.utils.WeatherUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class WeatherMessageService {
    /**
     * 表白模板号
     */
    private static String TEMPLATE_ID = "zh5Xpto70UfwB2HvzK0_RMPUyUxUvX_gvSW3ttQ6w3A";

    public void sendMessage(WeatherMessageConfigInfo config) {
        SendTemplateMessageRequest<WeatherMessageData> request = generateRequest(config);
        VxUtil.sendMessage(JSONUtil.toJsonStr(request));
    }

    /**
     * {{userName.DATA}}，
     * {{region.DATA}}今天的天气是{{textToday.DATA}}
     * 今天的温度是{{low.DATA}}~{{high.DATA}}℃ 想你的风是{{wdToday.DATA}}
     * 明天的天气是{{textTomorrow.DATA}} 今天是我们在一起的第{{holdDay.DATA}}天 最后，开心每一天！
     *
     * @param config
     * @return
     */
    private SendTemplateMessageRequest<WeatherMessageData> generateRequest(WeatherMessageConfigInfo config) {
        SendTemplateMessageRequest<WeatherMessageData> request = new SendTemplateMessageRequest<>();
        request.setTemplate_id(TEMPLATE_ID);  //修改成你的模板ID
        request.setTouser(config.getUid()); //修改成你的用户ID
        WeatherMessageData data = new WeatherMessageData();
        data.setUserName(new DataInfo(config.getUserName()));
        data.setHoldDay(new DataInfo(DateUtil.passDay(2022, 9, 16)));
        //todo:组装天气信息
        WeatherResponse weatherResponse = WeatherUtils.getWeather(config.getRegionCode());
        if (weatherResponse != null && weatherResponse.getResult() != null) {
            WeatherResponseResult result = weatherResponse.getResult();
            if (result.getLocation() != null) {
                data.setRegion(new DataInfo(result.getLocation().getCity() + result.getLocation().getName()));
            }
            if (!CollectionUtils.isEmpty(result.getForecasts())) {
                data.setTextToday(new DataInfo(result.getForecasts().get(0).getText_day()));
                data.setLow(new DataInfo(result.getForecasts().get(0).getLow()));
                data.setHigh(new DataInfo(result.getForecasts().get(0).getHigh()));
                data.setWdToday(new DataInfo(result.getForecasts().get(0).getWd_day() + result.getForecasts().get(0).getWc_day()));
                data.setTextTomorrow(new DataInfo(result.getForecasts().get(1).getText_day()));
            }
        }
        request.setData(data);
        return request;
    }
}
