package com.kakao.emoticon.cache.recycle;

public interface ByteArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 0x10000;

    byte[] get(int arg1);

    void put(byte[] arg1);
}

