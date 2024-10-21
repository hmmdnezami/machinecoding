package org.example.cache.model;

public interface Cache {
    public void insertKey(String key, String value) ;
    public String get(String key) ;
    public int getSize() ;
    public void removeKey(String key) ;

}
