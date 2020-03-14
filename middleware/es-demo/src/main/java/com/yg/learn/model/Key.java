package com.yg.learn.model;

public class Key {

    private String key;

    public Key(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    public String getKey() {
        return key;
    }
}
