package com.yg.learn.event;

public class WeatherEnvetMulticaster extends AbstractEventMulticaster {

    @Override
    protected void doStart() {
        System.out.println("begin weather event");
    }

    @Override
    protected void doEnd() {
        System.out.println("end weather event");
    }

}
