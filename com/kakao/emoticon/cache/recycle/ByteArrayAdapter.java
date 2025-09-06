package com.kakao.emoticon.cache.recycle;

import java.util.Arrays;

public final class ByteArrayAdapter implements ArrayAdapterInterface {
    private static final String TAG = "ByteArrayPool";

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public int getArrayLength(Object object0) {
        return this.getArrayLength(((byte[])object0));
    }

    public int getArrayLength(byte[] arr_b) {
        return arr_b.length;
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public Object newArray(int v) {
        return this.newArray(v);
    }

    public byte[] newArray(int v) {
        return new byte[v];
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public void resetArray(Object object0) {
        this.resetArray(((byte[])object0));
    }

    public void resetArray(byte[] arr_b) {
        Arrays.fill(arr_b, 0);
    }
}

