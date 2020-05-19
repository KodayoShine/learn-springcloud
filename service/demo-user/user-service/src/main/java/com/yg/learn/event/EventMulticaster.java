package com.yg.learn.event;

public interface EventMulticaster {

    /** 广播事件*/
    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener listener);

    void removeListener(WeatherListener listener);
}
