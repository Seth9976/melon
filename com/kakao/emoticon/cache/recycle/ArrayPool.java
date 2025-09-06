package com.kakao.emoticon.cache.recycle;

public interface ArrayPool {
    void clearMemory();

    Object get(int arg1, Class arg2);

    void put(Object arg1, Class arg2);

    void trimMemory(int arg1);
}

