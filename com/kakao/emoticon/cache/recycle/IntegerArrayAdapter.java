package com.kakao.emoticon.cache.recycle;

import java.util.Arrays;

public final class IntegerArrayAdapter implements ArrayAdapterInterface {
    private static final String TAG = "IntegerArrayPool";

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public int getArrayLength(Object object0) {
        return this.getArrayLength(((int[])object0));
    }

    public int getArrayLength(int[] arr_v) {
        return arr_v.length;
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public Object newArray(int v) {
        return this.newArray(v);
    }

    public int[] newArray(int v) {
        return new int[v];
    }

    @Override  // com.kakao.emoticon.cache.recycle.ArrayAdapterInterface
    public void resetArray(Object object0) {
        this.resetArray(((int[])object0));
    }

    public void resetArray(int[] arr_v) {
        Arrays.fill(arr_v, 0);
    }
}

