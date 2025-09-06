package com.kakao.emoticon.cache.recycle;

public final class LruByteArrayPool implements ByteArrayPool {
    static final int DEFAULT_SIZE = 0x400000;
    private final ArrayPool arrayPool;

    public LruByteArrayPool() {
        this(0x400000);
    }

    public LruByteArrayPool(int v) {
        this.arrayPool = new LruArrayPool(v);
    }

    @Override  // com.kakao.emoticon.cache.recycle.ByteArrayPool
    public byte[] get(int v) {
        return (byte[])this.arrayPool.get(v, byte[].class);
    }

    @Override  // com.kakao.emoticon.cache.recycle.ByteArrayPool
    public void put(byte[] arr_b) {
        synchronized(this) {
            this.arrayPool.put(arr_b, byte[].class);
        }
    }
}

