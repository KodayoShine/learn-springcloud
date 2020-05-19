package com.yg.learn.event;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEventMulticaster implements  EventMulticaster {

    private List<WeatherListener> listeners = new ArrayList<>();

    @Override
    public void multicastEvent(WeatherEvent event) {
        doStart();
        listeners.stream().forEach(listener -> listener.onWeatherEvent(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherListener listener) {
        listeners.remove(listener);
    }

    /** 模板方法,由具体的抽象类进行实现 */
    protected abstract void doEnd();

    protected abstract void doStart();
}
