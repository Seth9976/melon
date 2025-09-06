package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 0x20;
    private int size;
    private long[] values;

    public LongArray() {
        this(0x20);
    }

    public LongArray(int v) {
        this.values = new long[v];
    }

    public void add(long v) {
        int v1 = this.size;
        long[] arr_v = this.values;
        if(v1 == arr_v.length) {
            this.values = Arrays.copyOf(arr_v, v1 * 2);
        }
        int v2 = this.size;
        this.size = v2 + 1;
        this.values[v2] = v;
    }

    public long get(int v) {
        if(v < 0 || v >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + v + ", size is " + this.size);
        }
        return this.values[v];
    }

    public int size() {
        return this.size;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }
}

