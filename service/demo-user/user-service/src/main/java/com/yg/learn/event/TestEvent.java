package com.yg.learn.event;

public class TestEvent {

    public static void main(String[] args) {
        EventMulticaster eventMulticaster = new WeatherEnvetMulticaster();
        WeatherListener snowListener = new SnowListener();
        WeatherListener rainListener = new RainListener();

        // 添加监听器
        eventMulticaster.addListener(snowListener);
        eventMulticaster.addListener(rainListener);

        WeatherEvent snowEvent = new SnowEvent();
        WeatherEvent rainEvent = new RainEvent();

        // 广播事件
        eventMulticaster.multicastEvent(snowEvent);
        eventMulticaster.multicastEvent(rainEvent);

        // 移除监听器
        eventMulticaster.removeListener(rainListener);

        // 广播事件
        eventMulticaster.multicastEvent(snowEvent);
        eventMulticaster.multicastEvent(rainEvent);
    }


}
