package com.kakao.emoticon.cache.recycle;

public interface ArrayAdapterInterface {
    int getArrayLength(Object arg1);

    int getElementSizeInBytes();

    String getTag();

    Object newArray(int arg1);

    void resetArray(Object arg1);
}

