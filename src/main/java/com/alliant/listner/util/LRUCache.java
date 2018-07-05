package com.alliant.listner.util;

import com.alliant.listner.data.response.AuthResponse;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache extends LinkedHashMap<String, AuthResponse> {

    private int cacheSize;

    public LRUCache(int cacheSize){
        super(16, 0.75F, true);
        this.cacheSize=cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, AuthResponse> eldest) {
        return size()>=cacheSize;
    }
}
