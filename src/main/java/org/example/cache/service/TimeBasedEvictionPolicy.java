package org.example.cache.service;

import org.example.cache.model.EvictionPolicy;

import java.util.HashMap;

public class TimeBasedEvictionPolicy implements EvictionPolicy {


    @Override
    public String getValueBasedOnKey(String key) {
        return null;
    }

    @Override
    public void keyinsertion(String key, String value) {

    }

    @Override
    public void removeKey(String key) {

    }
}
