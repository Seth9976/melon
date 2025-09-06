package com.kakao.emoticon.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LruCache {
    private final LinkedHashMap cache;
    private int currentSize;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int v) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.currentSize = 0;
        this.initialMaxSize = v;
        this.maxSize = v;
    }

    public void clearMemory() {
        this.trimToSize(0);
    }

    public boolean contains(Object object0) {
        return this.cache.containsKey(object0);
    }

    private void evict() {
        this.trimToSize(this.maxSize);
    }

    public Object get(Object object0) {
        return this.cache.get(object0);
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Object object0) [...] // Inlined contents

    public void onItemEvicted(Object object0, Object object1) {
    }

    public Object put(Object object0, Object object1) {
        if(1 >= this.maxSize) {
            return null;
        }
        Object object2 = this.cache.put(object0, object1);
        if(object1 != null) {
            ++this.currentSize;
        }
        if(object2 != null) {
            --this.currentSize;
        }
        this.evict();
        return object2;
    }

    public Object remove(Object object0) {
        Object object1 = this.cache.remove(object0);
        if(object1 != null) {
            --this.currentSize;
        }
        return object1;
    }

    public void setSizeMultiplier(float f) {
        if(f < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(((float)this.initialMaxSize) * f);
        this.evict();
    }

    public void trimToSize(int v) {
        while(this.currentSize > v) {
            Object object0 = this.cache.entrySet().iterator().next();
            ((Map.Entry)object0).getValue();
            --this.currentSize;
            Object object1 = ((Map.Entry)object0).getKey();
            this.cache.remove(object1);
        }
    }
}

