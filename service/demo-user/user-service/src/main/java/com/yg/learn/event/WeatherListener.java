package com.yg.learn.event;

public interface WeatherListener {

    /** 监听到事件之后,所做的行为 */
    void onWeatherEvent(WeatherEvent event);
}
