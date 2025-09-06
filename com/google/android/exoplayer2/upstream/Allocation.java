package com.google.android.exoplayer2.upstream;

public final class Allocation {
    public final byte[] data;
    public final int offset;

    public Allocation(byte[] arr_b, int v) {
        this.data = arr_b;
        this.offset = v;
    }
}

