package org.example.cache.model;

public interface EvictionPolicy {
    public String getValueBasedOnKey(String key) ;
    public void keyinsertion(String key, String value) ;
    public void removeKey(String key) ;
}
