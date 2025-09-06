package com.kakao.emoticon.cache.module;

import androidx.collection.u;
import com.kakao.emoticon.cache.Key;

public enum MemoryLruCache {
    INSTANCE;

    private u memoryCache;
    private final SafeKeyGenerator safeKeyGenerator;

    private MemoryLruCache() {
        this.memoryCache = new u(((int)(Runtime.getRuntime().maxMemory() / 0x400L)) / 8) {
            @Override  // androidx.collection.u
            public int sizeOf(Object object0, Object object1) {
                return this.sizeOf(((String)object0), ((byte[])object1));
            }

            public int sizeOf(String s, byte[] arr_b) {
                return arr_b.length / 0x400;
            }
        };
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public void addToMemoryCache(Key key0, byte[] arr_b) {
        if(this.getFromMemCache(key0) == null && arr_b.length > 0) {
            String s = this.safeKeyGenerator.getSafeKey(key0);
            this.memoryCache.put(s, arr_b);
        }
    }

    public byte[] getFromMemCache(Key key0) {
        String s = this.safeKeyGenerator.getSafeKey(key0);
        return (byte[])this.memoryCache.get(s);
    }
}

