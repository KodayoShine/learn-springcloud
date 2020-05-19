package com.yg.learn.event;

public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if(event instanceof RainEvent) {
            System.out.println(" hello RainListener : " + event.getWeather());
        }
    }
}
