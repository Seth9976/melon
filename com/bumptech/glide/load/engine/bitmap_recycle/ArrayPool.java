package com.bumptech.glide.load.engine.bitmap_recycle;

public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 0x10000;

    void clearMemory();

    Object get(int arg1, Class arg2);

    Object getExact(int arg1, Class arg2);

    void put(Object arg1);

    @Deprecated
    void put(Object arg1, Class arg2);

    void trimMemory(int arg1);
}

